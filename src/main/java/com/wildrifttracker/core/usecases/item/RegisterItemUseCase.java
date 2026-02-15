package com.wildrifttracker.core.usecases.item;

import com.wildrifttracker.domain.dtos.item.CreateItemPayloadDto;
import com.wildrifttracker.infra.database.models.Item;
import com.wildrifttracker.infra.database.repositories.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RegisterItemUseCase {
    ItemRepository itemRepository;

    @Autowired
    public RegisterItemUseCase(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item create(@Valid CreateItemPayloadDto payload) {
        Item itemToCreate = new Item();

        itemToCreate.setName(payload.name());
        itemToCreate.setAttributes(payload.attributes());
        itemToCreate.setCost(payload.cost());

        return this.itemRepository.save(itemToCreate);
    }
}

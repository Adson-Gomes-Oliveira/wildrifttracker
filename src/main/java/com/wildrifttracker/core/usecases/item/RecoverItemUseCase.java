package com.wildrifttracker.core.usecases.item;

import com.wildrifttracker.domain.enums.ErrorMessages;
import com.wildrifttracker.infra.database.models.Item;
import com.wildrifttracker.infra.database.repositories.ItemRepository;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class RecoverItemUseCase {
    ItemRepository itemRepository;

    @Autowired
    public RecoverItemUseCase(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAll() {
        return this.itemRepository.findAll();
    }

    public Item getById(Long userId) {
        return this.itemRepository
                .findById(userId)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessages.PLAYER_NOT_FOUND.getMessage())
                );
    }
}

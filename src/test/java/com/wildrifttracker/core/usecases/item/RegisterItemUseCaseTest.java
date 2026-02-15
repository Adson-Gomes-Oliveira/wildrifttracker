package com.wildrifttracker.core.usecases.item;

import com.wildrifttracker.core.usecases.item.RegisterItemUseCase;
import com.wildrifttracker.domain.dtos.item.CreateItemPayloadDto;
import com.wildrifttracker.infra.database.models.Item;
import com.wildrifttracker.infra.database.repositories.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Core :: Usecases :: Item :: RegisterItemUseCaseTest")
public class RegisterItemUseCaseTest {
    @DisplayName("Testing method: create")
    @Test
    public void createTest() {
        String name = "varus";
        String attr = "adc";
        int cost = 10;

        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);

        CreateItemPayloadDto payloadTest = new CreateItemPayloadDto(
                name,
                attr,
                cost
        );
        RegisterItemUseCase useCaseTest = new RegisterItemUseCase(itemRepository);

        Item itemResult = new Item();
        itemResult.setName(name);

        Mockito.when(itemRepository.save(Mockito.any(Item.class))).thenReturn(itemResult);

        Item useCaseResult = useCaseTest.create(payloadTest);

        assertEquals(name, useCaseResult.getName());
    }
}

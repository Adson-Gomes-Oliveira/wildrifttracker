package com.wildrifttracker.core.usecases.item;

import com.wildrifttracker.core.usecases.item.RecoverItemUseCase;
import com.wildrifttracker.infra.database.models.Item;
import com.wildrifttracker.infra.database.repositories.ItemRepository;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Core :: Usecases :: Item :: RecoverItemUseCaseTest")
public class RecoverItemUseCaseTest {
    @DisplayName("Testing method: getAll")
    @Test
    public void getAllTest() {
        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);

        RecoverItemUseCase useCaseTest = new RecoverItemUseCase(itemRepository);

        List<Item> itemResult = new ArrayList<>();

        itemResult.add(new Item());
        itemResult.add(new Item());

        Mockito.when(itemRepository.findAll()).thenReturn(itemResult);

        List<Item> useCaseResult = useCaseTest.getAll();

        assertEquals(2, useCaseResult.size());
        assertEquals(itemResult.size(), useCaseResult.size());
    }

    @DisplayName("Testing method: getById")
    @Test
    public void getByIdTest() {
        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);

        RecoverItemUseCase useCaseTest = new RecoverItemUseCase(itemRepository);

        Item itemResult = new Item();

        itemResult.setName("test");

        Mockito.when(itemRepository.findById(123L)).thenReturn(Optional.of(itemResult));

        Item useCaseResult = useCaseTest.getById(123L);

        assertEquals(itemResult.getName(), useCaseResult.getName());
    }

    @DisplayName("Testing method: getById - Not Found")
    @Test
    public void getByIdNotFoundExceptionTest() {
        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);

        RecoverItemUseCase useCaseTest = new RecoverItemUseCase(itemRepository);

        Mockito.when(itemRepository.findById(123L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> useCaseTest.getById(123L));
    }
}

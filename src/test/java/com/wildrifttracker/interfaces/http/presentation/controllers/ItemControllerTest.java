package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.core.usecases.item.RecoverItemUseCase;
import com.wildrifttracker.core.usecases.item.RegisterItemUseCase;
import com.wildrifttracker.domain.dtos.item.CreateItemPayloadDto;
import com.wildrifttracker.domain.dtos.item.ReturnItemDto;
import com.wildrifttracker.infra.database.models.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interfaces :: Http :: Presentation :: Controllers :: ItemController")
class ItemControllerTest {

    private ItemController itemController;
    private RegisterItemUseCase registerItemUseCase;
    private RecoverItemUseCase recoverItemUseCase;

    @BeforeEach
    void setUp() {
        this.registerItemUseCase = Mockito.mock(RegisterItemUseCase.class);
        this.recoverItemUseCase = Mockito.mock(RecoverItemUseCase.class);
        this.itemController = new ItemController(
                registerItemUseCase,
                recoverItemUseCase
        );
    }

    @DisplayName("Testing method: registerItem - Should receive a record and return a full item object")
    @Test
    void registerItem() {
        CreateItemPayloadDto itemPayload = new CreateItemPayloadDto(
                "rabbadon",
                "80+ magic resist",
                3200
        );

        Item itemResult = new Item();
        itemResult.setName(itemPayload.name());

        Mockito.when(registerItemUseCase.create(itemPayload)).thenReturn(itemResult);

        ResponseEntity<ReturnItemDto> result = itemController.registerItem(itemPayload);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(itemResult.getName(), Objects.requireNonNull(result.getBody()).name());
    }

    @DisplayName("Testing method: getAllItems")
    @Test
    void getAllItems() {
        List<Item> itemResult = new ArrayList<>();
        itemResult.add(new Item());
        itemResult.add(new Item());

        Mockito.when(recoverItemUseCase.getAll()).thenReturn(itemResult);

        ResponseEntity<List<ReturnItemDto>> result = itemController.getAllItems();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(itemResult.size(), Objects.requireNonNull(result.getBody()).size());
    }

    @DisplayName("Testing method: getItemById")
    @Test
    void getItemById() {
        Item itemResult = new Item();
        itemResult.setName("teste");

        Mockito.when(recoverItemUseCase.getById(123L)).thenReturn(itemResult);

        ResponseEntity<ReturnItemDto> result = itemController.getItemById(123L);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(itemResult.getName(), Objects.requireNonNull(result.getBody()).name());
    }
}

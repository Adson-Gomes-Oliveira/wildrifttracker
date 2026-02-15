package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.core.usecases.item.RecoverItemUseCase;
import com.wildrifttracker.core.usecases.item.RegisterItemUseCase;
import com.wildrifttracker.domain.dtos.item.CreateItemPayloadDto;
import com.wildrifttracker.domain.dtos.item.ReturnItemDto;
import com.wildrifttracker.domain.utils.DataPreparer;
import com.wildrifttracker.infra.database.models.Item;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracker/item")
@Tag(name = "Items")
public class ItemController {
    private final RecoverItemUseCase recoverItemUseCase;
    private final RegisterItemUseCase registerItemUseCase;

    @Autowired
    public ItemController(
            RegisterItemUseCase registerItemUseCase,
            RecoverItemUseCase recoverItemUseCase
    ) {
        this.recoverItemUseCase = recoverItemUseCase;
        this.registerItemUseCase = registerItemUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ReturnItemDto>> getAllItems() {
        List<Item> result = this.recoverItemUseCase.getAll();

        List<ReturnItemDto> resultSanitized = DataPreparer
                .sanitizeListData(ReturnItemDto::new, result);

        return ResponseEntity.status(HttpStatus.OK).body(resultSanitized);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ReturnItemDto> getItemById(@PathVariable Long itemId) {
        Item result = this.recoverItemUseCase.getById(itemId);

        ReturnItemDto resultSanitized = DataPreparer
                .sanitizeUniqueData(ReturnItemDto::new, result);

        return ResponseEntity.status(HttpStatus.OK).body(resultSanitized);
    }

    @PostMapping("/register")
    public ResponseEntity<ReturnItemDto> registerItem(
            @RequestBody CreateItemPayloadDto payload
    ) {
        Item result = this.registerItemUseCase.create(payload);

        ReturnItemDto resultSanitized = DataPreparer
                .sanitizeUniqueData(ReturnItemDto::new, result);

        return ResponseEntity.status(HttpStatus.CREATED).body(resultSanitized);
    }
}

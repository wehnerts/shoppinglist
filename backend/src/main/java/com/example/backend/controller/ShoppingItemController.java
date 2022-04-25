package com.example.backend.controller;

import com.example.backend.model.ShoppingItem;
import com.example.backend.service.ShoppingItemsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingitem")
public class ShoppingItemController {

    private final ShoppingItemsService shoppingItemsService;

    public ShoppingItemController(ShoppingItemsService shoppingItemsService) {
        this.shoppingItemsService = shoppingItemsService;
    }

    @GetMapping
    public List<ShoppingItem> getShoppingItems () {
        return shoppingItemsService.getShoppingItems();
    }

}

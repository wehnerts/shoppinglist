package com.example.backend.service;

import com.example.backend.model.ShoppingItem;
import com.example.backend.repository.ShoppingItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemsService {

    private final ShoppingItemsRepo shoppingItemsRepo;

    @Autowired
    public ShoppingItemsService(ShoppingItemsRepo shoppingItemsRepo) {
        this.shoppingItemsRepo = shoppingItemsRepo;
    }

    public List<ShoppingItem> getShoppingItems() {
        return shoppingItemsRepo.getShoppingItems();
    }
}

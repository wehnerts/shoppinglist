package com.example.backend.service;

import com.example.backend.model.ShoppingItem;
import com.example.backend.repository.ShoppingItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemsService {

    private final ShoppingItemsRepo shoppingItemsRepo;
    private final IdService idService;

    @Autowired
    public ShoppingItemsService(ShoppingItemsRepo shoppingItemsRepo, IdService idService) {
        this.shoppingItemsRepo = shoppingItemsRepo;
        this.idService = idService;
    }

    public List<ShoppingItem> getShoppingItems() {
        return shoppingItemsRepo.getShoppingItems();
    }

    public ShoppingItem addNewItem(ShoppingItem newItem) {
        newItem.setId(idService.generateId());
        return shoppingItemsRepo.addNewItem(newItem);
    }
}

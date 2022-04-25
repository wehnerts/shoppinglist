package com.example.backend.repository;

import com.example.backend.model.ShoppingItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShoppingItemsRepo {

    private final List<ShoppingItem> shoppingItems = new ArrayList<>();

    public List<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }
}

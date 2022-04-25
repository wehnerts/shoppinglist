package com.example.backend.service;
import com.example.backend.model.ShoppingItem;
import com.example.backend.repository.ShoppingItemsRepo;
import org.junit.jupiter.api.Test;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShoppingItemsServiceTest {
ShoppingItemsRepo shoppingItemsRepo = mock(ShoppingItemsRepo.class);
IdService idService = mock(IdService.class);

ShoppingItemsService shoppingItemsService = new ShoppingItemsService(shoppingItemsRepo, idService);

List<ShoppingItem> shoppingItems = new ArrayList<>();

    @Test
    void getShoppingItems() {
        //GIVEN
        ShoppingItem item1 = new ShoppingItem("1", "Äpfel");
        ShoppingItem item2 = new ShoppingItem("2", "Banane");
        when(shoppingItemsRepo.getShoppingItems()).thenReturn(List.of(item1, item2));
        //WHEN

        //THEN
    }

    @Test
    void addNewItem() {
    }
}
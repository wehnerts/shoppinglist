package com.example.backend.service;
import com.example.backend.model.ShoppingItem;
import com.example.backend.repository.ShoppingItemsRepo;
import org.junit.jupiter.api.Test;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShoppingItemsServiceTest {
ShoppingItemsRepo shoppingItemsRepo = mock(ShoppingItemsRepo.class);
IdService idService = mock(IdService.class);

ShoppingItemsService shoppingItemsService = new ShoppingItemsService(shoppingItemsRepo, idService);

List<ShoppingItem> shoppingItems = new ArrayList<>();

    @Test
    void getShoppingItems() {
        //GIVEN
        ShoppingItem item1 = new ShoppingItem("1", "Apfel");
        ShoppingItem item2 = new ShoppingItem("2", "Käse");
        when(shoppingItemsRepo.getShoppingItems()).thenReturn(List.of(item1, item2));
        //WHEN

        List<ShoppingItem> actual = shoppingItemsService.getShoppingItems();

        //THEN
        List<ShoppingItem> expected = new ArrayList<>(List.of(new ShoppingItem("1", "Apfel"), new ShoppingItem("2", "Käse")));

        assertEquals(expected, actual);
        verify(shoppingItemsRepo).getShoppingItems();

    }

    @Test
    void addNewItem() {
        //GIVEN
        when(idService.generateId()).thenReturn("10");

        //WHEN

        ShoppingItem newItem = new ShoppingItem(null, "Mehl");

        ShoppingItem actual = shoppingItemsService.addNewItem(newItem);

        //THEN
        ShoppingItem expected = new ShoppingItem("10", "Mehl");
        assertEquals(expected, actual);
        verify(idService).generateId();

    }
}
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
    private final ShoppingItemsRepo shoppingItemsRepo = mock(ShoppingItemsRepo.class);
    private final IdService idService = mock(IdService.class);

    private final ShoppingItemsService shoppingItemsService = new ShoppingItemsService(shoppingItemsRepo, idService);

    @Test
    void getShoppingItems() {
        //GIVEN
        ShoppingItem item1 = new ShoppingItem("1", "Apfel");
        ShoppingItem item2 = new ShoppingItem("2", "Käse");
        when(shoppingItemsRepo.getShoppingItems()).thenReturn(List.of(item1, item2));
        //WHEN

        List<ShoppingItem> actual = shoppingItemsService.getShoppingItems();

        //THEN
        List<ShoppingItem> expected = List.of(new ShoppingItem("1", "Apfel"), new ShoppingItem("2", "Käse"));

        verify(shoppingItemsRepo).getShoppingItems();
        assertEquals(expected, actual);
    }

    @Test
    void addNewItem() {
        //GIVEN
        when(idService.generateId()).thenReturn("10");
        when(shoppingItemsRepo.addNewItem(new ShoppingItem("10", "Mehl"))).thenReturn(new ShoppingItem("10", "Mehl"));

        //WHEN
        ShoppingItem newItem = new ShoppingItem(null, "Mehl");
        ShoppingItem actual = shoppingItemsService.addNewItem(newItem);

        //THEN
        ShoppingItem expected = new ShoppingItem("10", "Mehl");
        verify(idService).generateId();
        verify(shoppingItemsRepo).addNewItem(expected);
        assertEquals(expected, actual);
    }
}

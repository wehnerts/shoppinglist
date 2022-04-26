package com.example.backend.controller;

import com.example.backend.model.ShoppingItem;
import com.example.backend.repository.ShoppingItemsRepo;
import com.example.backend.service.IdService;
import com.example.backend.service.ShoppingItemsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShoppingItemControllerTest {

    @MockBean
    private IdService idService;

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient testClient;

    @Autowired
    private ShoppingItemsRepo shoppingItemsRepo;

    @BeforeEach
    public void cleanUp(){
        shoppingItemsRepo.deleteAll();
    }

    @Test
    void getAllItems(){
        //GIVEN
        ShoppingItem item1 = new ShoppingItem("1", "Mehl");
        shoppingItemsRepo.addNewItem(item1);

        //WHEN
        List<ShoppingItem> actual = testClient.get()
                .uri("/api/shoppingitem")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(ShoppingItem.class)
                .returnResult()
                .getResponseBody();


        //THEN
        List<ShoppingItem> expected = List.of(new ShoppingItem("1", "Mehl"));
        assertEquals(expected, actual);
    }

    @Test
    void addNewItem(){
        //GIVEN
        when(idService.generateId()).thenReturn("10");
        ShoppingItem item1 = new ShoppingItem(null, "Mehl");

        //WHEN
        ShoppingItem actual = testClient.post()
                .uri("/api/shoppingitem")
                .bodyValue(item1)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(ShoppingItem.class)
                .returnResult()
                .getResponseBody();

        //THEN
        verify(idService).generateId();
        ShoppingItem expected = new ShoppingItem("10", "Mehl");
        assertEquals(expected, actual);
    }
}

package com.example.restfull.books.restbooks.controller;

import com.example.restfull.books.restbooks.service.MongoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveItemsControllerTest {

    @Mock
    private MongoService mongoService;

    @Test
    void saveBooksInMongo() {

        SaveItemsController saveItemsController = new SaveItemsController(mongoService);


        doNothing().when(mongoService).fetchAndSaveBooksFromJsonPlaceHolder();


        ResponseEntity<HttpStatus> response = saveItemsController.saveBooksInMongo();


        assertNotNull(response);
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        verify(mongoService, times(1)).fetchAndSaveBooksFromJsonPlaceHolder();



    }
}
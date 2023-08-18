package com.example.restfull.books.restbooks.service;

import com.example.restfull.books.restbooks.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class JsonPlaceholderServiceTest {

    private final String API_BASE_URL = "https://jsonplaceholder.typicode.com";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private JsonPlaceholderService jsonPlaceholderService;



    @Test
    void whenFetchBooksThenReturnBooksArray() {

        Book[] list = {new Book(1L, "", "")};

        when(restTemplate.getForObject(API_BASE_URL + "/posts", Book[].class))
                .thenReturn(list);


        Book[] response = jsonPlaceholderService.fetchBooks();

        assertNotNull(response);
        assertEquals(Book.class, response[0].getClass());


    }
}
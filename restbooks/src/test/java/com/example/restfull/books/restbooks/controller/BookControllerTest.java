package com.example.restfull.books.restbooks.controller;

import com.example.restfull.books.restbooks.model.Book;
import com.example.restfull.books.restbooks.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BookControllerTest {


    @Mock
    private BookService service;


    @InjectMocks
    private BookController controller;



    @Test
    void whenFindAllThenSuccess() {

        List<Book> list = new ArrayList<>();
        list.add(new Book(1L, "", ""));


        when(service.findAll())
                .thenReturn(list);


        ResponseEntity<List<Book>> response = controller.findAll();


        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ArrayList.class, Objects.requireNonNull(response.getBody()).getClass());
        assertEquals(Book.class, response.getBody().get(0).getClass());


    }

    @Test
    void whenFindByIdThenSuccess() {


        when(service.findById(anyLong()))
                .thenReturn(new Book());


        ResponseEntity<Book> response = controller.findById(3L);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Book.class, Objects.requireNonNull(response.getBody()).getClass());

    }
}
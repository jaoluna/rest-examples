package com.example.restfull.books.restbooks.service;

import com.example.restfull.books.restbooks.model.Book;
import com.example.restfull.books.restbooks.model.dto.BookDTO;
import com.example.restfull.books.restbooks.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class MongoServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private JsonPlaceholderService jsonPlaceholderService;

    @Test
    void whenFetchAndSaveBooksFromJsonPlaceHolderThenSaveToMongo() {

        MongoService mongoService = new MongoService(bookRepository, jsonPlaceholderService);

        Book[] list = {new Book(1L, "", "")};
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(list[0].getId());
        bookDTO.setTitle(list[0].getTitle());
        bookDTO.setAuthor(list[0].getAuthor());

        when(jsonPlaceholderService.fetchBooks())
                .thenReturn(list);

        mongoService.fetchAndSaveBooksFromJsonPlaceHolder();

        verify(bookRepository, times(list.length)).save(any(BookDTO.class));


    }
}

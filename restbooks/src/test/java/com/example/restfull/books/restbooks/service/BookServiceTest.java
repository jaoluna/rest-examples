package com.example.restfull.books.restbooks.service;

import com.example.restfull.books.restbooks.exceptions.BookNotFoundException;
import com.example.restfull.books.restbooks.exceptions.BookServiceException;
import com.example.restfull.books.restbooks.model.Book;
import com.example.restfull.books.restbooks.model.dto.BookDTO;
import com.example.restfull.books.restbooks.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private BookService bookService;





    @Test
    void whenFindAllThenSuccess() {

        List<BookDTO> listDTO = new ArrayList<>();
        listDTO.add(new BookDTO(1L, "", ""));

        when(bookRepository.findAll())
                .thenReturn(listDTO);
        when(mapper.map(listDTO.get(0), Book.class))
                .thenReturn(new Book());


        List<Book> response = bookService.findAll();

        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(Book.class, response.get(0).getClass());


    }

    @Test
    void whenFindByIdThenSuccess() {
        BookDTO bookDTO = new BookDTO(1L, "", "");

        when(bookRepository.findById(anyLong()))
                .thenReturn(Optional.of(bookDTO));
        when(mapper.map(bookDTO, Book.class))
                .thenReturn(new Book());


        Book response = bookService.findById(1L);

        assertNotNull(response);
        assertEquals(Book.class, response.getClass());




    }


    @Test
    void whenFindAllThenReturnException(){


        when(bookRepository.findAll())
                .thenThrow(new BookServiceException("Failed to fetch all books", new Exception()));

        try{
            List<Book> response = bookService.findAll();
        }catch (BookServiceException exception){
            assertEquals(BookServiceException.class, exception.getClass());
            assertEquals("Failed to fetch all books", exception.getMessage());

        }

    }


    @Test
    void whenFindByIdThenReturnException(){


        when(bookRepository.findById(anyLong()))
                .thenThrow(new BookNotFoundException("Book not found with ID:"));

        try{
            Book response = bookService.findById(2L);
        }catch (BookNotFoundException exception){
            assertEquals(BookNotFoundException.class, exception.getClass());
            assertEquals("Book not found with ID:", exception.getMessage());

        }

    }


    @Test
    void whenFindAllThenReturnExceptionService(){


        when(bookRepository.findById(anyLong()))
                .thenThrow(new BookServiceException("Failed to fetch book with ID:2", new Exception()));

        try{
            Book response = bookService.findById(2L);
        }catch (BookServiceException exception){
            assertEquals(BookServiceException.class, exception.getClass());
            assertEquals("Failed to fetch book with ID:2", exception.getMessage());

        }

    }


}
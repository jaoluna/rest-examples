package com.example.restfull.books.restbooks.service;


import com.example.restfull.books.restbooks.exceptions.BookNotFoundException;
import com.example.restfull.books.restbooks.exceptions.BookServiceException;
import com.example.restfull.books.restbooks.model.Book;
import com.example.restfull.books.restbooks.model.dto.BookDTO;
import com.example.restfull.books.restbooks.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }


    public List<Book> findAll() {

        List<Book> response = new ArrayList<>();

        try {
            List<BookDTO> booksDTO = bookRepository.findAll();

            response = booksDTO.stream()
                    .map(bookDTO -> modelMapper.map(bookDTO, Book.class))
                    .toList();

//            for (BookDTO book : booksDTO) {
//                Book responseItem = modelMapper.map(book, Book.class);
//                response.add(responseItem);
//            }


        } catch (Exception exception) {
            throw new BookServiceException("Failed to fetch all books", exception);
        }

        return response;

    }

    public Book findById(Long id) {

        Book response = new Book();

        try {

            Optional<BookDTO> bookDTO = bookRepository.findById(id);

            response = bookDTO.map(book -> modelMapper.map(book, Book.class))
                    .orElseThrow(() -> new BookNotFoundException("Book not found with ID:" + id));

        } catch (BookNotFoundException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new BookServiceException("Failed to fetch book with ID:" + id, exception);
        }

        return response;
    }


}

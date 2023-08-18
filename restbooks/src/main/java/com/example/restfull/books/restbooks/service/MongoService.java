package com.example.restfull.books.restbooks.service;


import com.example.restfull.books.restbooks.model.Book;
import com.example.restfull.books.restbooks.model.dto.BookDTO;
import com.example.restfull.books.restbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoService {

    private final BookRepository bookRepository;
    private final JsonPlaceholderService jsonPlaceHolderService;


    @Autowired
    public MongoService(BookRepository bookRepository, JsonPlaceholderService jsonPlaceHolderService) {
        this.bookRepository = bookRepository;
        this.jsonPlaceHolderService = jsonPlaceHolderService;
    }


    public void fetchAndSaveBooksFromJsonPlaceHolder(){

        Book[] books = jsonPlaceHolderService.fetchBooks();


        for (Book book : books){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthor(book.getAuthor() != null || book.getAuthor().isEmpty() ? book.getAuthor() : "Autor Desconhecido");
            bookRepository.save(bookDTO);
        }



    }


}

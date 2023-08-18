package com.example.restfull.books.restbooks.controller;


import com.example.restfull.books.restbooks.model.Book;
import com.example.restfull.books.restbooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;


    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }



    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }


}

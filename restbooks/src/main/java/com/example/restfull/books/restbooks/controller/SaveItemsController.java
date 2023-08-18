package com.example.restfull.books.restbooks.controller;


import com.example.restfull.books.restbooks.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/save_to_db")
public class SaveItemsController {

    private final MongoService mongoService;

    @Autowired
    public SaveItemsController(MongoService mongoService) {
        this.mongoService = mongoService;
    }


    @GetMapping("/save_items")
    public ResponseEntity<HttpStatus> saveBooksInMongo() {

        mongoService.fetchAndSaveBooksFromJsonPlaceHolder();

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }


}

package com.example.restfull.books.restbooks.service;


import com.example.restfull.books.restbooks.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonPlaceholderService {

    private final String API_BASE_URL = "https://jsonplaceholder.typicode.com";
    private final RestTemplate restTemplate;

    @Autowired
    public JsonPlaceholderService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    public Book[] fetchBooks(){
        return restTemplate.getForObject(API_BASE_URL + "/posts", Book[].class);
    }




}

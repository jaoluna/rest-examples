package com.example.restfull.books.restbooks.repository;

import com.example.restfull.books.restbooks.model.dto.BookDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookDTO, Long> {
}

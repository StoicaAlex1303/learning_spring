package com.example.demo.services;


import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public Book getByName(String bookName) {
        return bookRepository.findByName(bookName);
    }


    public Book getById(Long id) {
        return bookRepository.findById(id).get();
    }
}
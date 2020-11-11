package com.example.demo1.services;

import com.example.demo1.models.Book;
import com.example.demo1.repositories.BookRepository;
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

    public Book getByName(String bookName){
        return bookRepository.findByName(bookName);
    }


    public Book getById(Long id) {
        return bookRepository.findById(id).get();
    }

    public Book getByAuthor(String bookAuthor) {
        return bookRepository.findByAuthor(bookAuthor);
    }

    public void deleteByID(Long id){
        bookRepository.deleteById(id);
    }
}

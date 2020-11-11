package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SimpleController{

    @Value("${spring.application.name}")
    String appName;

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/books")
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.list();
    }

    @GetMapping("/books/{name}")
    @ResponseBody
    public Book getBooks(@PathVariable("name") String bookName) {
        return bookService.getByName(bookName);
    }

    @GetMapping("/books/filter")
    @ResponseBody
    public Book getBooks(@RequestParam() Long id) {
        return bookService.getById(id);
    }


}

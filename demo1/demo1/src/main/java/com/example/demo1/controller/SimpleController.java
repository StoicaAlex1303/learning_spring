package com.example.demo1.controller;

import com.example.demo1.models.Book;
import com.example.demo1.repositories.BookRepository;
import com.example.demo1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class SimpleController{

    @Value("${spring.application.name}")
    String appName;

    @Autowired
    BookService bookService;

//    @GetMapping("/")
//    public String homePage(Model model) {
//        model.addAttribute("appName", appName);
//        return "home";
//    }

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


//    @GetMapping("/books/filter")
//    @ResponseBody
//    public Book getBooks(@RequestParam() Long id) {
//        return bookService.getById(id);
//    }

    @GetMapping("")
    @ResponseBody
    public Book getById(@RequestParam() Long id){
        return bookService.getById(id);
    }


    @GetMapping("/books/filter/{author}")
    @ResponseBody
    public Book getByAuthor(@PathVariable("author") String bookAuthor){
        return bookService.getByAuthor(bookAuthor);
    }

//    @PutMapping(path="/add/{name}/{author}/{id}")
//    public  String addNewBook (@PathVariable String name, @PathVariable String author, @PathVariable Long id) {
//
//        Book newBook = new Book();
//        newBook.save(name,author, id);
//        return "Saved";
//    }



//    @PutMapping("")
//    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
//
//        return bookService.getById(id).map(book -> {
//            book.setName(newBook.getName());
//            book.setAuthor(newBook.getAuthor());
//
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
//    }
//
//    @PostMapping("/ex/books")
//    @ResponseBody
//    public String postBooks() {
//        return "Post some Books";
//    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        bookService.deleteByID(id);
        return "redirect:/books";
    }




}

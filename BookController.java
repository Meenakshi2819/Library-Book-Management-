package com.example.demo.Controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;



@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    
    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }

   
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

   
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
    
    @PutMapping("/{id}/availability")
    public Book updateAvailability(
            @PathVariable int id,
            @RequestParam boolean available) {

        return bookService.updateAvailability(id, available);
    }

  
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }
}
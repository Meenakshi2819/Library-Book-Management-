package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.BookNotFoundException;
import com.example.demo.Model.Book;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

 
    public Book addBook(Book book) {

        for (Book existingBook : books) {
            if (existingBook.getBookId() == book.getBookId()) {
                throw new IllegalArgumentException(
                    "Book ID already exists");
            }
        }

        books.add(book);
        return book;
    }

   
    public Book getBookById(int id) {

        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }

        throw new BookNotFoundException(
            "Book not found with ID: " + id);
    }

  
    public List<Book> getAllBooks() {
        return books;
    }

   
    public Book updateAvailability(int id, boolean available) {

        Book book = getBookById(id);
        book.setAvailable(available);

        return book;
    }

  
    public String deleteBook(int id) {

        Book book = getBookById(id);
        books.remove(book);

        return "Book deleted successfully with ID: " + id;
    }
}
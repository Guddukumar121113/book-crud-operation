package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.Service.BookService;
import com.api.book.bootrestbook.entities.Book;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {

        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")

    public Book getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }
//  hrough post method we add book details in my dataabase
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        return b;
    }

    // Delets books
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        this.bookService.deleteBook(bookId);
    }

    // update book
    @PutMapping("/books/{bookId}")
    public void updaBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        this.bookService.updateBook(book,bookId);
    }

}

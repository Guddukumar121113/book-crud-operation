package com.api.book.bootrestbook.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(45, "java compliler ", "xyz"));
        list.add(new Book(4, "python compliler ", "gjj"));
        list.add(new Book(5, "script compliler ", "hys"));
    }

    // get all book
    public List<Book> getAllBooks() {
        return list;
    }

    // get single book
    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }

    // adding the boook
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    // delete book
    public void deleteBook(int bid) {
        list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
    }

    // update book

    public void updateBook(Book book,int bookId) {
        list = list.stream().map(b -> {
            if (b.getId() == bookId) 
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;

        }).collect(Collectors.toList());
    }
}

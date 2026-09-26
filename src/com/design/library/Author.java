package com.design.library;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Author {
    private final String id;
    private final String name;
    private final List<Book> books;

    public Author(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }
}

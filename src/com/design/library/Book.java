package com.design.library;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Book {

    private final String id;
    private final String title;
    private final Author author;
    private final List<BookCopy> bookCopies;

    public Book(String title, Author author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.bookCopies = new ArrayList<>();
        author.addBook(this);
    }

    public String getTitle() {
        return title;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void addCopy(int copies) {

        for(int i = 0; i < copies; i++) {
            bookCopies.add(new BookCopy(this));
        }
    }
}

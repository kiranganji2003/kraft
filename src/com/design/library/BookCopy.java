package com.design.library;

import java.util.UUID;

public class BookCopy {
    private final String id;
    private final Book book;
    private BookStatus bookStatus;

    public BookCopy(Book book) {
        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.bookStatus = BookStatus.AVAILABLE;
    }

    public String getTitle() {
        return book.getTitle();
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public boolean isAvailable() {
        return bookStatus == BookStatus.AVAILABLE;
    }

    public void borrowBook() {
        if(!isAvailable()) {
            throw new RuntimeException("Book not available");
        }

        bookStatus = BookStatus.BORROWED;
    }


    @Override
    public String toString() {
        return "BookCopy{" +
                "id='" + id + '\'' +
                ", book=" + book.getTitle() +
                ", bookStatus=" + bookStatus +
                '}';
    }

    public void returnBook() {
        bookStatus = BookStatus.AVAILABLE;
    }
}

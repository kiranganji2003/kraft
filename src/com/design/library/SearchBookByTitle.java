package com.design.library;

import java.util.List;

public class SearchBookByTitle implements SearchBookStrategy {

    @Override
    public BookCopy searchBook(String query, Library library) {

        List<Book> books = library.getBooks();
        Book searchedBook = null;

        for(Book book : books) {
            if(book.getTitle().equals(query)) {
                searchedBook = book;
                break;
            }
        }

        if(searchedBook == null) {
            throw new RuntimeException("book not found");
        }

        for(BookCopy bookCopy : searchedBook.getBookCopies()) {
            if(bookCopy.getBookStatus() == BookStatus.AVAILABLE) {
                return bookCopy;
            }
        }

        throw new RuntimeException("book copies not available");
    }
}

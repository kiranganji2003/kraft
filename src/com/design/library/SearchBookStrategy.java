package com.design.library;

public interface SearchBookStrategy {
    BookCopy searchBook(String query, Library library);
}

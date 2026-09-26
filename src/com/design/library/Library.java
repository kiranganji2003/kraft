package com.design.library;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Library {
    private final String id;
    private final String name;
    private final List<Author> authors;
    private final List<Book> books;
    private final List<Member> members;
    private final List<Loan> loans;

    public Library(String name, List<Author> authors, List<Book> books, List<Member> members) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.authors = authors;
        this.books = books;
        this.members = members;
        this.loans = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }
}

package com.design.library;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Author author1 = new Author("Chetan Bhagat");
        Author author2 = new Author("Raman Bhagat");

        Book book1 = new Book("Think & Grow Rich", author1);
        Book book2 = new Book("3 Idiots", author2);

        book1.addCopy(3);
        book2.addCopy(1);

        Member member1 = new Member("kiran");

        Library library = new Library("Wisdom Library", List.of(author1, author2),
        List.of(book1, book2), List.of(member1));

        SearchBookStrategy searchBookStrategy = new SearchBookByTitle();

        LibrayService librayService = new LibrayService(library, searchBookStrategy, 15);

        BookCopy bookCopy = librayService.searchBook("3 Idiots");

        Loan loan = librayService.borrowBook(bookCopy, member1);
        librayService.returnBook(loan);
        System.out.println(loan);
        bookCopy = librayService.searchBook("3 Idiots");
        System.out.println(bookCopy);

    }
}

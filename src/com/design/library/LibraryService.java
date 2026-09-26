package com.design.library;

import java.time.LocalDate;

public class LibraryService {

    private final Library library;
    private final SearchBookStrategy searchBookStrategy;
    private final int MIN_DUE_DAYS;

    public LibraryService(Library library, SearchBookStrategy searchBookStrategy, int MIN_DUE_DAYS) {
        this.library = library;
        this.searchBookStrategy = searchBookStrategy;
        this.MIN_DUE_DAYS = MIN_DUE_DAYS;
    }

    public BookCopy searchBook(String query) {
        return searchBookStrategy.searchBook(query, library);
    }

    public Loan borrowBook(BookCopy bookCopy, Member member) {
        bookCopy.borrowBook();
        Loan loan = new Loan(bookCopy, member, LocalDate.now(),
                LocalDate.now().plusDays(MIN_DUE_DAYS));

        member.addLoan(loan);
        library.addLoan(loan);

        return loan;
    }

    public void returnBook(Loan loan) {
        loan.close();
    }
}

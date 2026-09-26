package com.design.library;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private final String id;
    private final BookCopy bookCopy;
    private final Member member;
    private final LocalDate borrowedDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    public Loan(BookCopy bookCopy, Member member, LocalDate borrowedDate, LocalDate dueDate) {
        this.id = UUID.randomUUID().toString();
        this.bookCopy = bookCopy;
        this.member = member;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", bookCopy=" + bookCopy.getTitle() +
                ", member=" + member +
                ", borrowedDate=" + borrowedDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }

    public void close() {
        bookCopy.returnBook();
        returnDate = LocalDate.now();
    }
}

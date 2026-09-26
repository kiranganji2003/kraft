package com.design.library;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member {
    private final String id;
    private final String name;
    private final List<Loan> loans;

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                '}';
    }

    public Member(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.loans = new ArrayList<>();
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }
}

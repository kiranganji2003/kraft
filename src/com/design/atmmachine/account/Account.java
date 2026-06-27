package com.design.atmmachine.account;

import com.design.atmmachine.atm.AtmCard;
import com.design.atmmachine.bank.Bank;
import com.design.atmmachine.bank.Transactions;

import java.util.ArrayList;
import java.util.List;

public class Account implements Transactions {
    private final String number;
    private final String holderName;
    private final Bank bankName;
    private int availableBalance;
    private AtmCard atmCard;
    private List<String> transactions;

    @Override
    public String toString() {
        return "Account{" +
                "availableBalance=" + availableBalance +
                ", bankName=" + bankName +
                ", holderName='" + holderName + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public Account(String number, String holderName, Bank bankName, int availableBalance) {
        this.number = number;
        this.holderName = holderName;
        this.bankName = bankName;
        this.availableBalance = availableBalance;
        this.atmCard = null;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void withdraw(int amount) {
        if(amount > this.availableBalance) {
            throw new RuntimeException("insufficient balance in account");
        }

        this.availableBalance -= amount;
        transactions.add("WITHDRAWN " + amount);
    }

    @Override
    public void deposit(int amount) {
        this.availableBalance += amount;
        transactions.add("DEPOSITED " + amount);
    }

    @Override
    public List<String> getMiniTransaction() {
        List<String> list = new ArrayList<>();
        for(int i = transactions.size() - 1; i >= Math.max(transactions.size() - 3, 0); i--) {
            list.add(transactions.get(i));
        }
        return list;
    }

    @Override
    public int getBalance() {
        return this.availableBalance;
    }

    public AtmCard createAtmCard(String atmpin) {
        if(this.atmCard != null) {
            throw new RuntimeException("already have ATM card for this account");
        }

        this.atmCard = new AtmCard(this.holderName, this.bankName, this, atmpin);

        return this.atmCard;
    }
}

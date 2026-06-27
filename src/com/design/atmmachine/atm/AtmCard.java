package com.design.atmmachine.atm;

import com.design.atmmachine.account.Account;
import com.design.atmmachine.bank.Bank;
import com.design.atmmachine.bank.Transactions;

import java.util.List;
import java.util.UUID;

public class AtmCard implements Transactions {

    private final String cardId;
    private final String cardHolderName;
    private final Bank bankName;
    private final Account linkedAccount;
    private String atmPin;

    @Override
    public String toString() {
        return "AtmCard{" +
                "cardId='" + cardId + '\'' +
                ", linkedAccount=" + linkedAccount +
                ", atmPin='" + atmPin + '\'' +
                '}';
    }

    public AtmCard(String cardHolderName, Bank bankName, Account linkedAccount, String atmPin) {
        this.cardId = UUID.randomUUID().toString();
        this.cardHolderName = cardHolderName;
        this.bankName = bankName;
        this.linkedAccount = linkedAccount;
        this.atmPin = atmPin;
    }

    public String getAtmPin() {
        return atmPin;
    }

    @Override
    public void withdraw(int amount) {
        linkedAccount.withdraw(amount);
    }

    @Override
    public void deposit(int amount) {
        linkedAccount.deposit(amount);
    }

    @Override
    public List<String> getMiniTransaction() {
        return linkedAccount.getMiniTransaction();
    }

    @Override
    public int getBalance() {
        return linkedAccount.getBalance();
    }
}

package com.design.atmmachine.bank;

import java.util.List;

public interface Transactions {
    void withdraw(int amount);
    void deposit(int amount);
    List<String> getMiniTransaction();
    int getBalance();
}

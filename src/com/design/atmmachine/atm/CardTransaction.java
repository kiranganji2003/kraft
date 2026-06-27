package com.design.atmmachine.atm;

import java.util.List;

public interface CardTransaction {
    void withdraw(int amount);
    void deposit(int[] amountQuantity);
    List<String> getMiniTransaction();
    int getBalance();
    void insertCard(AtmCard atmCard, String atmpin);
    void removeCard();
}

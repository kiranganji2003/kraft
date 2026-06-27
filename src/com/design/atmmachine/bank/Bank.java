package com.design.atmmachine.bank;

public enum Bank {
    SBI("STATE BANK OF INDIA"),
    BOI("BANK OF INDIA"),
    BOB("BANK OF BARODA"),
    HDFC("HDFC BANK");

    final String bank;

    Bank(String s) {
        bank = s;
    }

    public String getBank() {
        return bank;
    }
}

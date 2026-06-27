package com.design.atmmachine;

import com.design.atmmachine.account.Account;
import com.design.atmmachine.atm.AtmCard;
import com.design.atmmachine.atm.AtmMachine;
import com.design.atmmachine.bank.Bank;

import java.util.Arrays;

public class AtmApplication {

    public static void main(String[] args) {

        int[] denomination = {100, 200, 500};
        int[] quantity = {10, 10, 10};



        AtmMachine atmMachine = new AtmMachine("Atm-123", denomination, quantity);

        Account account1 = new Account("Account-1234", "Kiran", Bank.SBI, 1000);
        Account account2 = new Account("Account-1235", "Ramesh", Bank.BOB, 1000);
        Account account3 = new Account("Account-1236", "Nikita", Bank.BOB, 1000);
        Account account4 = new Account("Account-1237", "Sarika", Bank.HDFC, 10000);

        AtmCard atmCard1 = account1.createAtmCard("5656");
        AtmCard atmCard2 = account2.createAtmCard("5657");
        AtmCard atmCard3 = account3.createAtmCard("5658");
        AtmCard atmCard4 = account4.createAtmCard("5659");

        atmMachine.insertCard(atmCard4, "5659");
        atmMachine.withdraw(900);
        System.out.println(atmMachine);

        atmMachine.deposit(new int[]{3, 0, 0});
        atmMachine.deposit(new int[]{1, 2, 0});
        System.out.println( atmMachine);
        atmMachine.withdraw(3200);
        System.out.println(atmMachine);

    }

}

package com.design.patterns.behavioural;

interface ATMState {
    void insertCard(ATMMachine atmMachine);
    void authenticate(ATMMachine atmMachine);
    void withdraw(ATMMachine atmMachine);
}

class ATMMachine {

    private ATMState atmState;


    public ATMState getAtmState() {
        return atmState;
    }

    public ATMMachine() {
        this.atmState = new CardNotInserted();
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public void insertCard() {
        atmState.insertCard(this);
    }

    public void authenticate() {
        atmState.authenticate(this);
    }

    public void withdraw() {
        atmState.withdraw(this);

    }
}

class CardNotInserted implements ATMState {


    @Override
    public void insertCard(ATMMachine atmMachine) {
        System.out.println("card inserted");
        atmMachine.setAtmState(new CardInserted());
    }

    @Override
    public void authenticate(ATMMachine atmMachine) {
        System.out.println("error: insert card first");
    }

    @Override
    public void withdraw(ATMMachine atmMachine) {
        System.out.println("error: insert card first");
    }
}

class CardInserted implements ATMState {

    @Override
    public void insertCard(ATMMachine atmMachine) {
        System.out.println("error: card already inserted");
    }

    @Override
    public void authenticate(ATMMachine atmMachine) {
        System.out.println("card authenticated successfully");
        atmMachine.setAtmState(new AuthenticatedState());
    }

    @Override
    public void withdraw(ATMMachine atmMachine) {
        System.out.println("error: authenticate first");
    }
}

class AuthenticatedState implements ATMState {

    @Override
    public void insertCard(ATMMachine atmMachine) {
        System.out.println("error: already inserted");
    }

    @Override
    public void authenticate(ATMMachine atmMachine) {
        System.out.println("error: already authenticated");
    }

    @Override
    public void withdraw(ATMMachine atmMachine) {
        atmMachine.setAtmState(new Dispensing());
        atmMachine.getAtmState().withdraw(atmMachine);
    }
}

class Dispensing implements ATMState {

    @Override
    public void insertCard(ATMMachine atmMachine) {
        System.out.println("error: insert already inserted");
    }

    @Override
    public void authenticate(ATMMachine atmMachine) {
        System.out.println("error: already authenticated");
    }

    @Override
    public void withdraw(ATMMachine atmMachine) {
        System.out.println("withdrawn successfully");
        System.out.println("removing card");
        atmMachine.setAtmState(new CardNotInserted());
    }
}



public class StateDesign {

    public static void main(String[] args) {

        ATMMachine atmMachine = new ATMMachine();
        atmMachine.insertCard();
        atmMachine.authenticate();
        atmMachine.withdraw();

        atmMachine.insertCard();
        atmMachine.authenticate();
        atmMachine.withdraw();
    }

}

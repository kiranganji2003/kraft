package com.design.atmmachine.atm;

import java.util.Arrays;
import java.util.List;

public class AtmMachine implements CardTransaction {

    private final String machineId;
    private AtmSLotStatus atmSLotStatus;
    private AtmCard atmCard;
    private final int[] denomination;
    private int[] currencyQuantity;
    private int totalCash;

    @Override
    public String toString() {
        return "AtmMachine{" +
                "atmSLotStatus=" + atmSLotStatus +
                ", currencyQuantity=" + Arrays.toString(currencyQuantity) +
                ", totalCash=" + totalCash +
                '}';
    }

    public AtmMachine(String machineId, int[] denomination, int[] currencyQuantity) {
        this.machineId = machineId;
        this.denomination = denomination;
        this.currencyQuantity = currencyQuantity;
        this.atmSLotStatus = AtmSLotStatus.CARD_NOT_INSERTED;

        for(int i = 0; i < denomination.length; i++) {
            this.totalCash += (denomination[i] * currencyQuantity[i]);
        }
    }

    private void validateAtmSlot() {
        if(atmSLotStatus == AtmSLotStatus.CARD_NOT_INSERTED) {
            throw new RuntimeException("atm card not inserted");
        }
    }


    @Override
    public void withdraw(int amount) {
        validateAtmSlot();

        if(amount % 100 != 0) {
            throw new RuntimeException("amount should be multiple of 100");
        }
        else if(amount > this.totalCash) {
            throw new RuntimeException("Cash not available");
        }

        atmCard.withdraw(amount);
        this.totalCash -= amount;

        for(int i = denomination.length - 1; amount > 0 && i >= 0; i--) {
            int notesWithdrawn = Math.min(currencyQuantity[i], amount / denomination[i]);
            currencyQuantity[i] -= notesWithdrawn;
            amount -= (notesWithdrawn * denomination[i]);
        }

        System.out.println("Amount withdrawn successfully");
    }

    @Override
    public void deposit(int[] currencyQuantity) {
        validateAtmSlot();

        int totalDepositedAmount = 0;

        for(int i = 0; i < denomination.length; i++) {
            this.currencyQuantity[i] += currencyQuantity[i];
            int count = denomination[i] * currencyQuantity[i];
            totalDepositedAmount += count;
        }

        atmCard.deposit(totalDepositedAmount);
        this.totalCash += totalDepositedAmount;
        System.out.println("Amount deposited succesfully");
    }

    @Override
    public List<String> getMiniTransaction() {
        validateAtmSlot();
        return atmCard.getMiniTransaction();
    }

    @Override
    public int getBalance() {
        validateAtmSlot();
        return atmCard.getBalance();
    }

    @Override
    public void insertCard(AtmCard atmCard, String atmpin) {
        if(atmSLotStatus == AtmSLotStatus.CARD_INSERTED) {
            throw new RuntimeException("Already card inserted");
        }
        else if(!atmCard.getAtmPin().equals(atmpin)) {
            throw new RuntimeException("invalid atm pin");
        }

        this.atmCard = atmCard;
        this.atmSLotStatus = AtmSLotStatus.CARD_INSERTED;
    }

    @Override
    public void removeCard() {
        validateAtmSlot();
        this.atmCard = null;
        this.atmSLotStatus = AtmSLotStatus.CARD_NOT_INSERTED;
    }
}

package com.design.patterns.structural;

interface Payment {
    void pay(int amount, String account1, String account2);
}

class RazorpayPayment {
    void makePayment(String account1, String account2, int amount) {
        System.out.println("Razorpay payment done.");
        System.out.println("from " + account1 + " to " + account2 + " of amount " + amount);
    }
}

class RazorpayAdapter implements Payment {

    RazorpayPayment razorpayPayment;

    public RazorpayAdapter(RazorpayPayment razorpayPayment) {
        this.razorpayPayment = razorpayPayment;
    }

    @Override
    public void pay(int amount, String account1, String account2) {
        razorpayPayment.makePayment(account1, account2, amount);
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args) {

        Payment payment = new RazorpayAdapter(new RazorpayPayment());

        payment.pay(1299, "kiran@ybl", "ram@ybl");

    }
}

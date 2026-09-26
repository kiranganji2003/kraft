package com.design.patterns.structural;

class InventoryService {

    public void checkAvailability() {
        System.out.println("product available");
    }
}

class PaymentService {
    public void makePayment() throws Exception {
        System.out.println("payment done");
    }
}

class NotificationService {
    public void notifyUser() {
        System.out.println("notification done");
    }
}

class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.notificationService = new NotificationService();
    }

    public void makeOrder() throws Exception {
        inventoryService.checkAvailability();
        paymentService.makePayment();
        notificationService.notifyUser();
    }
}


public class Facade {

    public static void main(String[] args) {

        OrderFacade orderFacade = new OrderFacade();
        try {
            orderFacade.makeOrder();
        } catch (Exception e) {
            throw new RuntimeException("Order unsuccessful");
        }

    }

}

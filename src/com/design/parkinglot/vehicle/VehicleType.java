package com.design.parkinglot.vehicle;

public enum VehicleType {
    CAR(200), BIKE(100), TRUCK(300);

    private int price;

    VehicleType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

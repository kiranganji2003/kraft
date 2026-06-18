package com.design.parkinglot.ticket;

import com.design.parkinglot.pricing.PricingStrategy;
import com.design.parkinglot.vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private String id;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double price;

    public String getId() {
        return id;
    }

    public Ticket() {
        this.id = UUID.randomUUID().toString();
        this.entryTime = LocalDateTime.now();
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public double calculatePrice(PricingStrategy pricingStrategy, VehicleType vehicleType) {
        this.exitTime = LocalDateTime.now();
        this.price = pricingStrategy.calculatePrice(this, vehicleType);
        return this.price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", price=" + price +
                '}';
    }
}

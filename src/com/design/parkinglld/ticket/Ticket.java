package com.design.parkinglld.ticket;

import com.design.parkinglld.parking.ParkingSpot;
import com.design.parkinglld.vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;
    private final String id;
    private LocalDateTime exitTime;

    @Override
    public String toString() {
        return "Ticket{" +
                "vehicle=" + vehicle.getNumber() +
                ", parkingSpot=" + parkingSpot.getId() +
                ", entryTime=" + entryTime +
                ", id='" + id + '\'' +
                ", exitTime=" + exitTime +
                '}';
    }

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public String getId() {
        return id;
    }

    public int calculateFees(PricingStrategy pricingStrategy) {
        exitTime = LocalDateTime.now();
        int hours = Math.max(1, (int) Duration.between(entryTime, exitTime).toHours());
        return pricingStrategy.calculatePrice(hours);
    }
}

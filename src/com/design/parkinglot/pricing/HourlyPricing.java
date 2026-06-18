package com.design.parkinglot.pricing;

import com.design.parkinglot.ticket.Ticket;
import com.design.parkinglot.vehicle.VehicleType;

import java.time.Duration;

public class HourlyPricing implements PricingStrategy {

    private static final double HOURLY_CHARGE = 100;

    @Override
    public double calculatePrice(Ticket ticket, VehicleType vehicleType) {

        Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        long hours = Math.max(1, duration.toHours());

        return HOURLY_CHARGE * vehicleType.getPrice() * hours;
    }
}

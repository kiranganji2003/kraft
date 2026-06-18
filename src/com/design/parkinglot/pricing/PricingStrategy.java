package com.design.parkinglot.pricing;

import com.design.parkinglot.ticket.Ticket;
import com.design.parkinglot.vehicle.VehicleType;

public interface PricingStrategy {
    public double calculatePrice(Ticket ticket, VehicleType vehicleType);
}

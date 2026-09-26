package com.design.parkinglld.ticket;

public interface PricingStrategy {
    int calculatePrice(int hoursParked);
}

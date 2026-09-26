package com.design.parkinglld.ticket;

public class HourlyPricingStrategy implements PricingStrategy {

    private final int hourlyPrice;

    public HourlyPricingStrategy(int hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }


    @Override
    public int calculatePrice(int hoursParked) {
        return hourlyPrice * hoursParked;
    }
}

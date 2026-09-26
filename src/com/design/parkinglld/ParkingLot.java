package com.design.parkinglld;

import com.design.parkinglld.parking.ParkingFloor;
import com.design.parkinglld.parking.ParkingSpot;
import com.design.parkinglld.ticket.PricingStrategy;
import com.design.parkinglld.ticket.Ticket;
import com.design.parkinglld.vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private final Map<String, Ticket> activeTickets;
    private final List<ParkingFloor> parkingFloorList;
    private final PricingStrategy pricingStrategy;

    public ParkingLot(List<ParkingFloor> parkingFloorList, PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
        this.activeTickets = new HashMap<>();
        this.parkingFloorList = parkingFloorList;
    }

    Ticket parkVehicle(Vehicle vehicle) {

        ParkingSpot parkingSpot = null;

        for(ParkingFloor parkingFloor : parkingFloorList) {

            parkingSpot = parkingFloor.findAvailableParkingSpot(vehicle.getVehicleType());

            if(parkingSpot != null) {
                break;
            }

        }

        if(parkingSpot == null) {
            throw new RuntimeException("Parking spot not available");
        }

        parkingSpot.parkVehicle(vehicle);
        Ticket ticket = new Ticket(vehicle, parkingSpot);
        activeTickets.put(ticket.getId(), ticket);

        return ticket;
    }

    int unparkVehicle(Ticket ticket) {

        if(!activeTickets.containsKey(ticket.getId())) {
            throw new RuntimeException("invalid ticket");
        }

        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.unparkVehicle();

        activeTickets.remove(ticket.getId());

        return ticket.calculateFees(pricingStrategy);
    }
}

package com.design.parkinglot.parking;

import com.design.parkinglot.pricing.HourlyPricing;
import com.design.parkinglot.pricing.PricingStrategy;
import com.design.parkinglot.ticket.Ticket;
import com.design.parkinglot.vehicle.Vehicle;
import com.design.parkinglot.vehicle.VehicleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingService {
    private Map<String, ParkingSlot> activeParkingSlots;
    private List<ParkingFloor> parkingFloors;
    private PricingStrategy pricingStrategy;

    public ParkingService(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
        this.activeParkingSlots = new HashMap<>();
        pricingStrategy = new HourlyPricing();
    }

    public Ticket parkVehicle(Vehicle vehicle) {

        ParkingSlot parkingSlot = getAvailableParkingSlot(vehicle.getVehicleType());

        if(parkingSlot == null) {
            System.out.println("No parking slot available");
            return null;
        }

        parkingSlot.parkVehicle(vehicle);
        Ticket ticket = new Ticket();
        activeParkingSlots.put(ticket.getId(), parkingSlot);

        return ticket;
    }

    public double unparkVehicle(Ticket ticket) {

        if(!activeParkingSlots.containsKey(ticket.getId())) {
            System.out.println("Invalid ticket");
            return 0;
        }

        ParkingSlot parkingSlot = activeParkingSlots.get(ticket.getId());
        parkingSlot.unparkVehicle();
        activeParkingSlots.remove(ticket.getId());
        return ticket.calculatePrice(pricingStrategy, parkingSlot.getVehicleType());
    }

    private ParkingSlot getAvailableParkingSlot(VehicleType vehicleType) {

        for(ParkingFloor parkingFloor : parkingFloors) {

            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()) {

                if(parkingSlot.isAvailable() && parkingSlot.getVehicleType() == vehicleType) {
                    return parkingSlot;
                }
            }

        }

        return null;
    }

    public void showStatus() {
        for(ParkingFloor parkingFloor : parkingFloors) {
            System.out.println(parkingFloor);
        }
    }
}

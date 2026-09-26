package com.design.parkinglld.parking;

import com.design.parkinglld.vehicle.Vehicle;
import com.design.parkinglld.vehicle.VehicleType;

import java.util.List;

public class ParkingFloor {

    private final String floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(String floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot findAvailableParkingSpot(VehicleType vehicleType) {

        for(ParkingSpot parkingSpot : parkingSpots) {

            if(parkingSpot.isAvailable(vehicleType)) {

                return parkingSpot;
            }

        }

        return null;
    }
}

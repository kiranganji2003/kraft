package com.design.parkinglld.parking;

import com.design.parkinglld.vehicle.Vehicle;
import com.design.parkinglld.vehicle.VehicleType;


public class ParkingSpot {

    private final String id;
    private final ParkingSpotType parkingSpotType;
    private Vehicle vehicle;

    public String getId() {
        return id;
    }

    public ParkingSpot(String id, ParkingSpotType parkingSpotType) {
        this.id = id;
        this.parkingSpotType = parkingSpotType;
    }

    public boolean isAvailable(VehicleType vehicleType) {
        return parkingSpotType.name().equals(vehicleType.name()) && vehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void unparkVehicle() {
        this.vehicle = null;
    }
}

package com.design.parkinglot.parking;

import com.design.parkinglot.vehicle.Vehicle;
import com.design.parkinglot.vehicle.VehicleType;

public class ParkingSlot {
    private String id;
    private VehicleType vehicleType;
    private Vehicle vehicle;

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "id='" + id + '\'' +
                ", vehicleType=" + vehicleType +
                ", vehicle=" + vehicle +
                '}';
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParkingSlot(String id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void unparkVehicle() {
        this.vehicle = null;
    }
}

package com.design.parkinglot.vehicle;

public abstract class Vehicle {
    private String id;
    private VehicleType vehicleType;

    public Vehicle(String id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}

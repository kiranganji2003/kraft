package com.design.parkinglot.parking;

import java.util.List;

public class ParkingFloor {
    private String id;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(String id, List<ParkingSlot> parkingSlots) {
        this.id = id;
        this.parkingSlots = parkingSlots;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    @Override
    public String toString() {
        return "ParkingFloor{" +
                "id='" + id + '\'' +
                ", parkingSlots=" + parkingSlots +
                '}';
    }
}

package com.design.parkinglld;

import com.design.parkinglld.parking.ParkingFloor;
import com.design.parkinglld.parking.ParkingSpot;
import com.design.parkinglld.parking.ParkingSpotType;
import com.design.parkinglld.ticket.HourlyPricingStrategy;
import com.design.parkinglld.ticket.Ticket;
import com.design.parkinglld.vehicle.Bike;
import com.design.parkinglld.vehicle.Car;
import com.design.parkinglld.vehicle.Truck;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ParkingSpot parkingSpot1 = new ParkingSpot("ps1", ParkingSpotType.CAR);
        ParkingSpot parkingSpot2 = new ParkingSpot("ps2", ParkingSpotType.TRUCK);
        ParkingSpot parkingSpot3 = new ParkingSpot("ps3", ParkingSpotType.BIKE);

        ParkingFloor parkingFloor1 = new ParkingFloor("f1", List.of(parkingSpot1, parkingSpot2, parkingSpot3));


        ParkingSpot parkingSpot4 = new ParkingSpot("ps4", ParkingSpotType.CAR);
        ParkingSpot parkingSpot5 = new ParkingSpot("ps5", ParkingSpotType.TRUCK);
        ParkingSpot parkingSpot6 = new ParkingSpot("ps6", ParkingSpotType.BIKE);

        ParkingFloor parkingFloor2 = new ParkingFloor("f2", List.of(parkingSpot4, parkingSpot5, parkingSpot6));

        final int HOURLY_PRICE = 100;
        ParkingLot parkingLot = new ParkingLot(List.of(parkingFloor1, parkingFloor2), new HourlyPricingStrategy(HOURLY_PRICE));

        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");

        Bike bike1 = new Bike("4");
        Bike bike2 = new Bike("5");
        Bike bike3 = new Bike("6");

        Truck truck1 = new Truck("7");
        Truck truck2 = new Truck("8");
        Truck truck3 = new Truck("9");


        Ticket ticket1 = parkingLot.parkVehicle(car1);
        Ticket ticket2 = parkingLot.parkVehicle(car2);
        parkingLot.unparkVehicle(ticket2);
        Ticket ticket3 = parkingLot.parkVehicle(car3);
        System.out.println(ticket3);
    }
}

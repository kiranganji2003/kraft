package com.design.parkinglot;

import com.design.parkinglot.parking.ParkingFloor;
import com.design.parkinglot.parking.ParkingService;
import com.design.parkinglot.parking.ParkingSlot;
import com.design.parkinglot.ticket.Ticket;
import com.design.parkinglot.vehicle.*;

import java.util.Arrays;

public class ParkingLotApplication {

    public static void main(String[] args) {


        Vehicle bike1 = new Bike("b1");
        Vehicle car1 = new Car("c1");
        Vehicle truck1 = new Truck("t1");

        Vehicle bike2 = new Bike("b2");
        Vehicle car2 = new Car("c2");
        Vehicle truck2 = new Truck("t2");

        ParkingSlot slot1 = new ParkingSlot("s1", VehicleType.BIKE);
        ParkingSlot slot2 = new ParkingSlot("s2", VehicleType.CAR);
        ParkingSlot slot3 = new ParkingSlot("s1", VehicleType.BIKE);
        ParkingSlot slot4 = new ParkingSlot("s2", VehicleType.TRUCK);
//        ParkingSlot slot1 = new ParkingSlot("s1", VehicleType.BIKE);
//        ParkingSlot slot1 = new ParkingSlot("s1", VehicleType.BIKE);
//        ParkingSlot slot1 = new ParkingSlot("s1", VehicleType.BIKE);


        ParkingFloor floor1 = new ParkingFloor("f1", Arrays.asList(slot1, slot2));
        ParkingFloor floor2 = new ParkingFloor("f2", Arrays.asList(slot3, slot4));

        ParkingService parkingService = new ParkingService(Arrays.asList(floor1, floor2));

        Ticket ticket1 = parkingService.parkVehicle(bike1);
        Ticket ticket2 = parkingService.parkVehicle(car1);
        Ticket ticket3 = parkingService.parkVehicle(truck1);
        System.out.println(parkingService.unparkVehicle(ticket3));
        parkingService.showStatus();

//        parkingService.unparkVehicle(ticket3);
//        parkingService.showStatus();

    }

}

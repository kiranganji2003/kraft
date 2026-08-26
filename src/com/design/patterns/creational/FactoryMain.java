package com.design.patterns.creational;

enum VehicleType {
    BIKE, CAR, TRUCK
}

abstract class Vehicle {
    protected String number;

    public Vehicle(String number) {
        this.number = number;
    }

    abstract void start();
}

class Bike extends Vehicle {

    public Bike(String number) {
        super(number);
    }

    @Override
    void start() {
        System.out.println("Bike started; Bike number " + number);
    }
}

class Car extends Vehicle {

    public Car(String number) {
        super(number);
    }

    @Override
    void start() {
        System.out.println("Car started; Car number " + number);
    }
}

class Truck extends Vehicle {

    public Truck(String number) {
        super(number);
    }

    @Override
    void start() {
        System.out.println("Truck started; Truck number " + number);
    }
}


class VehicleFactory {

    static Vehicle getVehicle(VehicleType vehicleType, String number) {
        if(vehicleType == VehicleType.BIKE) {
            return new Bike(number);
        }
        else if(vehicleType == VehicleType.CAR) {
            return new Car(number);
        }
        else if(vehicleType == VehicleType.TRUCK) {
            return new Truck(number);
        }

        throw new IllegalArgumentException();
    }

}

public class FactoryMain {

    public static void main(String[] args) {

        Vehicle vehicle1 = VehicleFactory.getVehicle(VehicleType.BIKE, "1234");
        Vehicle vehicle2 = VehicleFactory.getVehicle(VehicleType.CAR, "5678");
        Vehicle vehicle3 = VehicleFactory.getVehicle(VehicleType.TRUCK, "3287");


        vehicle1.start();
        vehicle2.start();
        vehicle3.start();
    }

}

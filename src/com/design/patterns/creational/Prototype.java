package com.design.patterns.creational;

class Address {
    String addressLine1;
    String city;
    String pincode;

    public Address(String addressLine1, String city, String pincode) {
        this.addressLine1 = addressLine1;
        this.city = city;
        this.pincode = pincode;
    }

    Address copy() {
        return new Address(addressLine1, city, pincode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}

class Employee {
    String name;
    int salary;
    Address address;

    public Employee(String name, int salary, Address address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    Employee copy() {
        return new Employee(name, salary, address.copy());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}

public class Prototype {

    public static void main(String[] args) {
        Address address = new Address("laxmi chowk", "solapur", "413005");
        Employee e1 = new Employee("kiran", 1234, address);

        Employee e2 = e1.copy();

        address.city = "satara";
        e2.name = "ram";

        System.out.println(e1);
        System.out.println(e2);
    }

}

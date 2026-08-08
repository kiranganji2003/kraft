package com.design.patterns.creational;

class Customer {
    private String name;
    private String address;
    private String phone;
    private int age;
    private double salary;
    private boolean employed;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", employed=" + employed +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public Customer(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.phone = builder.phone;
        this.age = builder.age;
        this.salary = builder.salary;
        this.employed = builder.employed;
    }

    public static class Builder {
        private String name;
        private String address;
        private String phone;
        private int age;
        private double salary;
        private boolean employed;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public Builder employed(boolean employed) {
            this.employed = employed;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}

public class BuilderMain {

    public static void main(String[] args) {

        Customer customer = Customer.builder()
                .name("kiran")
                .age(23)
                .address("solapur")
                .phone("32324342")
                .salary(32.43)
                .employed(true)
                .build();


        System.out.println(customer);
    }

}

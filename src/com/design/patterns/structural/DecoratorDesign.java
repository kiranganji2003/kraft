package com.design.patterns.structural;


interface Coffee {
    int findCost();
    String description();
}

class BasicCoffee implements Coffee {

    @Override
    public int findCost() {
        return 20;
    }

    @Override
    public String description() {
        return "Basic Coffee";
    }
}


abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;


    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }


    @Override
    public int findCost() {
        return coffee.findCost() + 10;
    }

    @Override
    public String description() {
        return coffee.description() + ", milk";
    }
}

class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int findCost() {
        return coffee.findCost() + 5;
    }

    @Override
    public String description() {
        return coffee.description() + ", sugar";
    }
}


public class DecoratorDesign {
    public static void main(String[] args) {

        Coffee coffee = new BasicCoffee();

        System.out.println(coffee.findCost() + " " + coffee.description());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.findCost() + " " + coffee.description());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.findCost() + " " + coffee.description());

    }
}

package com.design.patterns.structural;

interface TV {
    void turnOn();
    void turnOff();
}

class SonyTv implements TV {

    @Override
    public void turnOn() {
        System.out.println("Turning on Sony Tv");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off Sony Tv");
    }
}

class SamsungTv implements TV {

    @Override
    public void turnOn() {
        System.out.println("Turning on Samsung Tv");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off Samsung Tv");
    }
}

abstract class Remote {
    protected TV tv;

    public Remote(TV tv) {
        this.tv = tv;
    }

    void power() {
        tv.turnOn();
    }
}

class BasicRemote extends Remote {

    public BasicRemote(TV tv) {
        super(tv);
    }

    public void volume() {
        System.out.println("Tv Volume Changing");
    }
}

class AdvancedRemote extends Remote {

    public AdvancedRemote(TV tv) {
        super(tv);
    }

    public void brightness() {
        System.out.println("Tv Brightness Changing");
    }
}

public class Bridge {
    public static void main(String[] args) {
        BasicRemote remote1 = new BasicRemote(new SonyTv());
        AdvancedRemote remote2 = new AdvancedRemote(new SamsungTv());

        remote1.power();
        remote1.volume();

        remote2.power();
        remote2.brightness();
    }
}

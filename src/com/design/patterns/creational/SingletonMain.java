package com.design.patterns.creational;

class Manager {

    private static Manager manager;

    private Manager() {  }

    public static Manager getInstance() {

        if(manager == null) {
            manager = new Manager();
        }

        return manager;
    }
}

class Leader {

    private static Leader leader;

    private Leader() {  }

    synchronized public static Leader getInstance() {

        if(leader == null) {
            leader = new Leader();
        }

        return leader;
    }
}

class Boss {
    private static volatile Boss boss;
    private static Object lock = new Object();

    private Boss() {  }

    public static Boss getInstance() {

        if(boss == null) {

            synchronized (lock) {

                if(boss == null) {
                    boss = new Boss();
                }

            }

        }

        return boss;
    }
}

class Singleton {

    private Singleton() {  }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

}

public class SingletonMain {

    public static void main(String[] args) {



    }

}

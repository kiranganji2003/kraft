package com.design.patterns.behavioural;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void notifyUser(String title);
}

interface Subject {
    void uploadVideo(String title);
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
}

class Subscriber implements Observer {

    private final String userName;

    Subscriber(String userName) {
        this.userName = userName;
    }


    @Override
    public void notifyUser(String title) {
        System.out.println(" " + userName + " received video : " + title);
    }
}

class YoutubeChannel implements Subject {

    private List<Observer> subscribersList;
    private final String channelName;

    public YoutubeChannel(String channelName) {
        this.subscribersList = new ArrayList<>();
        this.channelName = channelName;
    }

    @Override
    public void uploadVideo(String title) {
        System.out.println(channelName + " uploaded video : " + title);

        for(Observer observer : subscribersList) {
            observer.notifyUser(title);
        }
    }

    @Override
    public void subscribe(Observer observer) {
        subscribersList.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribersList.remove(observer);
    }
}

public class ObserverMain {
    public static void main(String[] args) {

        YoutubeChannel tech = new YoutubeChannel("Tech Guru");
        YoutubeChannel health = new YoutubeChannel("Fit Tuber");

        Subscriber subscriber1 = new Subscriber("Kiran");
        Subscriber subscriber2 = new Subscriber("Raman");
        Subscriber subscriber3 = new Subscriber("Rakesh");
        Subscriber subscriber4 = new Subscriber("Nikhil");

        tech.subscribe(subscriber1);
        tech.subscribe(subscriber2);
        tech.subscribe(subscriber3);
        tech.subscribe(subscriber4);

        health.subscribe(subscriber1);
        health.subscribe(subscriber4);

        health.uploadVideo("be fit");
        tech.uploadVideo("macbook latest");

    }
}

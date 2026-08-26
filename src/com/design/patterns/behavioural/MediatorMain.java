package com.design.patterns.behavioural;

import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void addUser(User user);
    void sendMessage(User sender, String message);
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received " + message);
    }
}

class ChatMediator implements Mediator {

    private String chatName;
    private List<User> userList;

    public ChatMediator(String chatName) {
        this.chatName = chatName;
        userList = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void sendMessage(User sender, String message) {

        System.out.println("\n" + chatName + " received message");
        System.out.println(sender.getName() + " sending message {" + message + "}");

        for(User user : userList) {
            if(user != sender) {
                user.receiveMessage(message);
            }
        }

    }
}


public class MediatorMain {
    public static void main(String[] args) {

        User kiran = new User("kiran");
        User raman = new User("raman");
        User rahul = new User("rahul");


        Mediator friendsChat = new ChatMediator("Office Buddies");
        friendsChat.addUser(kiran);
        friendsChat.addUser(rahul);
        friendsChat.addUser(raman);

        friendsChat.sendMessage(kiran, "Hello Everyone");
    }
}

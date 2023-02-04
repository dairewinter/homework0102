package org.example;

import java.util.*;

public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public List<User> getAllUsers(){
        if(users.isEmpty()){
            return null;
        }
        return users;
    }

    public Optional<User> getUserByLogin(String login){
        return users.stream().filter(user -> user.getLogin().equals(login)).findAny();
    }

    public Optional<User> getUserByLoginPassword(String login, String password){
        return users.stream().filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password)).findAny();
    }

    public void addUser(User user){
        this.users.add(user);
    }
}

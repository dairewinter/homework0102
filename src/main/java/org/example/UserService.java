package org.example;

import java.util.Collection;
import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<String> getAllUserLogins(){
        return userRepository.getAllUsers().stream().map(User::getLogin).toList();
    }

    public void addUser(String login, String password){
        User user = new User(login, password);
        boolean userExist = this.userRepository
                .getAllUsers()
                .stream()
                .anyMatch(u -> u.equals(user));
        if(userExist){
            throw new UserNonUniqueException();
        }
        if (login == null || password == null){
            throw new IllegalArgumentException();
        }
        if (login.isEmpty() || password.isEmpty()){
            throw new IllegalArgumentException();
        }

        this.userRepository.addUser(user);
    }

}

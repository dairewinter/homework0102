import org.example.User;
import org.example.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    private final UserRepository userRepository = new UserRepository();

    @Test
    void getEmptyListOfUsers() {
        assertNull(userRepository.getAllUsers());
    }

    @Test
    void getAllUsersTest() {
        User user = new User("login", "password");
        User user1 = new User("loginlogin", "passwordpassword");
        User user2 = new User("loginloginlogin", "passwordpasswordpassword");
        userRepository.addUser(user);
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        assertEquals(List.of(user, user1, user2), userRepository.getAllUsers());
    }

    @Test
    void getExistedUserByLoginTest() {
        User user = new User("login", "password");
        User user1 = new User("loginlogin", "passwordpassword");
        User user2 = new User("loginloginlogin", "passwordpasswordpassword");
        userRepository.addUser(user);
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        assertEquals(user, userRepository.getUserByLogin("login").orElse(null));
    }

    @Test
    void getNotExistedUserByLoginTest() {
        User user = new User("login", "password");
        User user1 = new User("loginlogin", "passwordpassword");
        User user2 = new User("loginloginlogin", "passwordpasswordpassword");
        userRepository.addUser(user);
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        assertNotEquals(user, userRepository.getUserByLogin("login").orElse(null));
    }

    @Test
    void getUserByLoginPasswordTest() {
        User user = new User("login", "password");
        User user1 = new User("loginlogin", "passwordpassword");
        User user2 = new User("loginloginlogin", "passwordpasswordpassword");
        userRepository.addUser(user);
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        assertEquals(user, userRepository.getUserByLoginPassword("login", "password").orElse(null));
    }

    @Test
    void getUserByOneLoginTest() {
        User user = new User("login", "password");
        User user1 = new User("loginlogin", "passwordpassword");
        User user2 = new User("loginloginlogin", "passwordpasswordpassword");
        userRepository.addUser(user);
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        assertEquals(user, userRepository.getAllUsers().stream()
                .filter(u -> u.getLogin().equals(user.getLogin()))
                .findAny().orElse(null));
    }

    @Test
    void getUserByOnePasswordTest() {
        User user = new User("login", "password");
        User user1 = new User("loginlogin", "passwordpassword");
        User user2 = new User("loginloginlogin", "passwordpasswordpassword");
        userRepository.addUser(user);
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        assertEquals(user, userRepository.getAllUsers().stream()
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .findAny().orElse(null));
    }
}

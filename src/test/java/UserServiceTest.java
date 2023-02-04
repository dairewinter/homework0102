import org.example.User;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void getAllUserLoginsTest(){
        when(userRepository.getAllUsers()).
                thenReturn(List.of(new User("login", "password"),
                                   new User("login2", "password2")));
    }

    @Test
    void addEmptyUserTest(){
        User user = new User("login", null);
        User user2 = new User(null, "password");
        User user3 = new User(null, null);
        User user4 = new User("login", "password");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Данные пользователя не заполнены");
        });
    }

    @Test
    void addNullUserTest(){
        User user = new User("login", null);
        User user2 = new User(null, "password");
        User user3 = new User(null, null);
        User user4 = new User("login", "password");
        Assertions.assertNull(user, "Поле пароля не заполнено");
        Assertions.assertNull(user2, "Поле логина не заполнено");
        Assertions.assertNull(user3, "Поля логина и пароля не заполнены");
    }

    @Test
    void addNotNullUserTest(){
        User user = new User("login", null);
        User user2 = new User(null, "password");
        User user3 = new User(null, null);
        User user4 = new User("login", "password");
        Assertions.assertNotNull(user4, "Поля заполнены верно");
    }

}

package Controllers;

import java.time.LocalDate;
import java.util.List;

import Models.User;
import Services.UserService;

public class UserController {

    private UserService userService;

    public UserController() {
        UserService _userService = new UserService();
        userService = _userService;
    }

    public User createUser(String name, String email, LocalDate birthday, String gender, String password) {
        User newUser = userService.createUser(name, email, birthday, gender, password);
        userService.saveUserToFile(newUser);
        return newUser;
    }

    public boolean login(String email, String password) {
        return userService.login(email, password);
    }

    public boolean checkEmailExists(String emailToCheck) {
        return userService.checkEmailExists(emailToCheck);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User userLogged = userService.getUserByEmailAndPassword(email, password);
        return userLogged;
    }

    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }
}

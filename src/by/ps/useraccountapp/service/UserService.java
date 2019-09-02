package by.ps.useraccountapp.service;

import by.ps.useraccountapp.entity.User;
import by.ps.useraccountapp.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User findUser(int id) throws UserNotFoundException;

    void updateUser(User user);

    void removeUser(User user);

    List<User> findAll();
}

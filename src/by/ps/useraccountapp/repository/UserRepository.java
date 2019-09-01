package by.ps.useraccountapp.repository;

import by.ps.useraccountapp.entity.User;

import java.util.List;

public interface UserRepository {

    void addUser(User user);

    User findById(int id);

    List<User> getUsers();

    void removeUser(User user);
}

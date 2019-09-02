package by.ps.useraccountapp.repository;

import by.ps.useraccountapp.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserRepository implements UserRepository{

    private static final String PATH = "users.bin";

    @Override
    public void addUser(User user) {

        List<User> users = getUsers();
        users.add(user);
        save(users);
    }

    @Override
    public User findById(int id) {

        List<User> users = getUsers();

        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    @Override
    public List<User> getUsers() {

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(PATH))) {
            return (List<User>) inputStream.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void removeUser(User user) {

        List<User> users = getUsers();
        users.remove(user);
        save(users);
    }

    private void save(List<User> users) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            outputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

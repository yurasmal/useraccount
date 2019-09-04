package by.ps.useraccountapp.service;

import by.ps.useraccountapp.application.config.AppConfig;
import by.ps.useraccountapp.entity.User;
import by.ps.useraccountapp.exception.UserNotFoundException;
import by.ps.useraccountapp.repository.UserRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileUserService implements UserService{

    private UserRepository userRepository = AppConfig.getRepository();

    @Override
    public void saveUser(User user) {

        userRepository.addUser(user);
    }

    @Override
    public User findUser(int id) throws UserNotFoundException {

        User user = userRepository.findById(id);

        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }

    @Override
    public void updateUser(User user) {
        
        if (userRepository.findById(user.getId()) != null) {
            
            userRepository.removeUser(user);
        }

        userRepository.addUser(user);
    }

    @Override
    public void removeUser(User user) {

        userRepository.removeUser(user);
    }

    @Override
    public List<User> findAll() {

        List<User> users = userRepository.getUsers();

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
            }
        });

        return users;
    }
}

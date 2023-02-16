package ru.itmagnat.springbootcrudidea.service;

import org.springframework.stereotype.Service;
import ru.itmagnat.springbootcrudidea.dao.UserDao;
import ru.itmagnat.springbootcrudidea.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }
}

package ru.itmagnat.springbootcrudidea.dao;

import org.springframework.data.repository.CrudRepository;
import ru.itmagnat.springbootcrudidea.model.User;

import java.util.List;

public interface UserDao extends CrudRepository<User,Long> {

    List<User> findByLastName(String lastName);

    User findById(long id);
}

package ru.itmagnat.springbootcrudidea.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.itmagnat.springbootcrudidea.model.User;

import java.util.List;

@Repository
@Transactional()
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        System.out.println(user);
        User oldUser = getUser(user.getId());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
    }

    @Override
    public User getUser(long id) {
        return entityManager.createQuery("FROM User user WHERE user.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}

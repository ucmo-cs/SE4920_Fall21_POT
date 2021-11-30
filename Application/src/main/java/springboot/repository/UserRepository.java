package springboot.repository;

import springboot.domain.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends RepositoryGeneric implements UserRepositoryInterface{

    public UserRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return null;
    }

    @Override
    public Optional<User> getUserByUsername(String name) {
        return null;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = em.createQuery("select u from User u", User.class)
                .getResultList();
        return users;
    }

    @Override
    public Optional<User> save(User user) {
        em.persist(user);
        return Optional.of(user);
    }

    @Override
    public void deleteById(int id) {

    }
}

package springboot.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.domain.Organization;
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
        Optional<User> opt = Optional.of(em.createQuery("select x from User x where x.id = :id", User.class)
                .setParameter("id", id).getSingleResult());

        return opt;
    }

    @Override
    public Optional<User> getUserByUsername(String name) {
        return null;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> opt = Optional.of(em.createQuery("select x from User x where x.email = :email", User.class)
                .setParameter("email", email).getSingleResult());

        return opt;
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

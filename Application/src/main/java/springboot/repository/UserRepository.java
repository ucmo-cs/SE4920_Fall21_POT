package springboot.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.domain.Organization;
import springboot.domain.Schedule;
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
        Optional<User> opt =
                em.createQuery("select x from User x where x.id = :id", User.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst();
        return opt;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<User> opt =
                em.createQuery("select x from User x where x.username = :username", User.class)
                .setParameter("username", username)
                .getResultStream()
                .findFirst();
        return opt;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> opt =
                em.createQuery("select x from User x where x.email = :email", User.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
        return opt;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = em.createQuery("select u from User u", User.class)
                .getResultList();
        return list;
    }

    @Override
    public Optional<User> save(User user) {
        em.persist(user);
        return Optional.of(user);
    }

    @Override
    public Optional<User> deleteById(int user_id) {
        Optional<User> opt =
                em.createQuery("select x from User x where x.id = :user_id", User.class)
                        .setParameter("user_id", user_id)
                        .getResultStream()
                        .findFirst();
        if(opt.isPresent()){
            em.remove(opt.get());
        }
        return opt;
    }

    @Override
    public Optional<User> update(User userUpdate) {
        Optional<User> opt =
                em.createQuery("select x from User x where x.id = :id", User.class)
                        .setParameter("id", userUpdate.getId())
                        .getResultStream()
                        .findFirst();
        if(opt.isPresent()){
            em.persist(userUpdate);
        }
        return opt;
    }
}

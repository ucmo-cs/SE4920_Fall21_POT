package springboot.repository;

import springboot.domain.Credentials;
import springboot.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface{

    Optional<User> getUserById(int id);
    Optional<User> getUserByUsername(String name);
    Optional<User> getUserByEmail(String email);
    List<User> getAllUsers();
    Optional<User> save(User user);
    Optional<User> deleteById(int id);
    Optional<User> update(User userUpdate);
}

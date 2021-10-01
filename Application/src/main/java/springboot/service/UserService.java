package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.domain.Organization;
import springboot.domain.User;
import springboot.repository.Org_UserRepositoryInterface;
import springboot.repository.Supervisor_SubordinateRepositoryInterface;
import springboot.repository.UserRepositoryInterface;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositoryInterface userRepository;
    @Autowired
    private Org_UserRepositoryInterface org_userRepository;
    @Autowired
    private Supervisor_SubordinateRepositoryInterface supervisor_subordinateRepository;

    public UserService(UserRepositoryInterface userRepository, Org_UserRepositoryInterface org_userRepository) {
        this.userRepository = userRepository;
        this.org_userRepository = org_userRepository;
    }

    public Optional<User> save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.getAllUsers();
    }

    public Optional<User> findById(int id) {
        return userRepository.getUserById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public Optional<Organization> getOrganizationByUserId(int id){
        return org_userRepository.getOrganizationByUserId(id);
    }

    public Optional<User> getSupervisorOfId(int id){
        return supervisor_subordinateRepository.getSupervisorOfId(id);
    }
    public List<User> getSubordinatesOfId(int id){
        return supervisor_subordinateRepository.getSubordinatesOfId(id);
    }
    public Optional<User> addSupervisor(int userId, int supervisorId){
        return supervisor_subordinateRepository.addSupervisor(userId, supervisorId);
    }
    public List<User> addSubordinate(int userId, int subordinateId){
        return supervisor_subordinateRepository.addSubordinate(userId, subordinateId);
    }
    public Optional<User> deleteSupervisor(int userId, int supervisorId){
        return supervisor_subordinateRepository.deleteSupervisor(userId, supervisorId);
    }
    public List<User> deleteSubordinate(int userId, int subordinateId){
        return supervisor_subordinateRepository.deleteSubordinate(userId, subordinateId);
    }
}

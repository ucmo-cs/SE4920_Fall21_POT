package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.domain.Organization;
import springboot.domain.Supervisor_Subordinate;
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

    public UserService(UserRepositoryInterface userRepository,
                       Org_UserRepositoryInterface org_userRepository,
    Supervisor_SubordinateRepositoryInterface supervisor_subordinateRepository) {
        this.userRepository = userRepository;
        this.org_userRepository = org_userRepository;
        this.supervisor_subordinateRepository = supervisor_subordinateRepository;
    }

    @Transactional
    public Optional<User> save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.getAllUsers();
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(int id) {
        return userRepository.getUserById(id);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Transactional
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Organization> getOrganizationByUserId(int id){
        return org_userRepository.getOrganizationByUserId(id);
    }

    @Transactional(readOnly = true)
    public Optional<User> getSupervisorOfId(int id){
        return supervisor_subordinateRepository.getSupervisorOfId(id);
    }

    @Transactional(readOnly = true)
    public List<User> getSubordinatesOfId(int id){
        return supervisor_subordinateRepository.getSubordinatesOfId(id);
    }

    @Transactional
    public Optional<User> addSupervisor(Supervisor_Subordinate supervisorSubordinate){
        return supervisor_subordinateRepository.addSupervisor(supervisorSubordinate);
    }

    @Transactional
    public List<User> addSubordinate(Supervisor_Subordinate supervisorSubordinate){
        return supervisor_subordinateRepository.addSubordinate(supervisorSubordinate);
    }

    @Transactional
    public Optional<User> deleteSupervisor(Supervisor_Subordinate supervisorSubordinate){
        return supervisor_subordinateRepository.deleteSupervisor(supervisorSubordinate);
    }

    @Transactional
    public List<User> deleteSubordinate(Supervisor_Subordinate supervisorSubordinate){
        return supervisor_subordinateRepository.deleteSubordinate(supervisorSubordinate);
    }
}

package springboot.repository;

import springboot.domain.Organization;
import springboot.domain.User;

import java.util.List;
import java.util.Optional;

public interface Supervisor_SubordinateRepositoryInterface {

    Optional<User> getSupervisorOfId(int id);
    List<User> getSubordinatesOfId(int id);
    Optional<User> addSupervisor(int userId, int supervisorId);
    List<User> addSubordinate(int userId, int subordinateId);
    Optional<User> deleteSupervisor(int userId, int supervisorId);
    List<User> deleteSubordinate(int userId, int subordinateId);
}

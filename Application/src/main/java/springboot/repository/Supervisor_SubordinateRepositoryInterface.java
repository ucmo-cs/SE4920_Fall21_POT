package springboot.repository;

import springboot.domain.Organization;
import springboot.domain.Supervisor_Subordinate;
import springboot.domain.User;

import java.util.List;
import java.util.Optional;

public interface Supervisor_SubordinateRepositoryInterface {

    Optional<User> getSupervisorOfId(int id);
    List<User> getSubordinatesOfId(int id);
    Optional<User> addSupervisor(Supervisor_Subordinate supervisorSubordinate);
    List<User> addSubordinate(Supervisor_Subordinate supervisorSubordinate);
    Optional<User> deleteSupervisor(Supervisor_Subordinate supervisorSubordinate);
    List<User> deleteSubordinate(Supervisor_Subordinate supervisorSubordinate);
}

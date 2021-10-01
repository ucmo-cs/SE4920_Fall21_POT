package springboot.repository;

import springboot.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class Supervisor_SubordinateRepository extends RepositoryGeneric implements Supervisor_SubordinateRepositoryInterface{

    public Supervisor_SubordinateRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<User> getSupervisorOfId(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getSubordinatesOfId(int id) {
        return null;
    }

    @Override
    public Optional<User> addSupervisor(int userId, int supervisorId) {
        return Optional.empty();
    }

    @Override
    public List<User> addSubordinate(int userId, int subordinateId) {
        return null;
    }

    @Override
    public Optional<User> deleteSupervisor(int userId, int supervisorId) {
        return Optional.empty();
    }

    @Override
    public List<User> deleteSubordinate(int userId, int subordinateId) {
        return null;
    }
}

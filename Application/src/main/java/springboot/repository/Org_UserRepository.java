package springboot.repository;

import springboot.domain.Organization;
import springboot.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class Org_UserRepository extends RepositoryGeneric implements Org_UserRepositoryInterface{

    public Org_UserRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<Organization> getOrganizationByUserId(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getUsersByOrganization(Organization organization) {
        return null;
    }
}

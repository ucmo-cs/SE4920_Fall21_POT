package springboot.repository;

import springboot.domain.Org_User;
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
        List<User> users = em.createQuery("select u from User u", User.class)
                .getResultList();
        return users;
    }

    @Override
    public Optional<User> addUserToOrganization(Org_User orgUser) {
        return Optional.empty();
    }

    @Override
    public Optional<User> deleteUserFromOrganization(Org_User orgUser) {
        return Optional.empty();
    }
}

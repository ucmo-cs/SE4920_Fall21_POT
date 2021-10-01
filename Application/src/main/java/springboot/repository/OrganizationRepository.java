package springboot.repository;

import springboot.domain.Organization;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OrganizationRepository extends RepositoryGeneric implements OrganizationRepositoryInterface{

    public OrganizationRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<Organization> getOrganizationById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Organization> getOrganizationByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Organization> getOrganizationByOwnerId(int id) {
        return Optional.empty();
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return null;
    }

    @Override
    public Optional<Organization> save(Organization organization) {
        return Optional.empty();
    }

    @Override
    public Optional<Organization> delete(int id) {
        return Optional.empty();
    }
}

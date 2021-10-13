package springboot.repository;

import springboot.domain.Organization;
import springboot.domain.User;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepositoryInterface {

    Optional<Organization> getOrganizationById(int id);
    Optional<Organization> getOrganizationByName(String name);
    Optional<Organization> getOrganizationByOwnerId(int id);
    List<Organization> getAll();
    Optional<Organization> save(Organization organization);
    Optional<Organization> delete(int id);
}

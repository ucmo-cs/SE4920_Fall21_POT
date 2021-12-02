package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.Organization;
import springboot.domain.User;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepositoryInterface{

    Optional<Organization> getOrganizationById(int id);
    List<Organization> getOrganizationByName(String name);
    List<Organization> getOrganizationByOwnerId(int id);
    List<Organization> getAll();
    Optional<Organization> save(Organization organization);
    Optional<Organization> delete(int id);
    Optional<Organization> update(Organization org);
}

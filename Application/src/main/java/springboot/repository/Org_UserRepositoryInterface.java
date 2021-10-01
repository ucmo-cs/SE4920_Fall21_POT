package springboot.repository;

import springboot.domain.Organization;
import springboot.domain.User;

import java.util.List;
import java.util.Optional;

public interface Org_UserRepositoryInterface {

    Optional<Organization> getOrganizationByUserId(int id);
    List<User> getUsersByOrganization(Organization organization);

}

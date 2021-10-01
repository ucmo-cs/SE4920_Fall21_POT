package springboot.repository;

import springboot.domain.Org_User;
import springboot.domain.Organization;
import springboot.domain.Supervisor_Subordinate;
import springboot.domain.User;

import java.util.List;
import java.util.Optional;

public interface Org_UserRepositoryInterface {

    Optional<Organization> getOrganizationByUserId(int id);
    List<User> getUsersByOrganization(Organization organization);
    Optional<User> addUserToOrganization(Org_User orgUser);
    Optional<User> deleteUserFromOrganization(Org_User orgUser);

}

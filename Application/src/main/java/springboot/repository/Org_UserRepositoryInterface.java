package springboot.repository;

import springboot.domain.Org_User;
import springboot.domain.Organization;
import springboot.domain.Supervisor_Subordinate;
import springboot.domain.User;

import java.util.List;
import java.util.Optional;

public interface Org_UserRepositoryInterface {

    List<Organization> getOrganizationByUserId(int id);
    List<User> getUsersByOrganizationId(int id);
    Optional<User> addUserToOrganization(Org_User orgUser);
    Optional<User> deleteUserFromOrganization(Org_User orgUser);

}

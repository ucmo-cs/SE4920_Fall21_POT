package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.domain.Org_User;
import springboot.domain.Organization;
import springboot.domain.User;
import springboot.repository.Org_UserRepositoryInterface;
import springboot.repository.OrganizationRepositoryInterface;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepositoryInterface organizationRepository;
    @Autowired
    private Org_UserRepositoryInterface org_userRepository;

    public OrganizationService(OrganizationRepositoryInterface organizationRepository, Org_UserRepositoryInterface orgUserRepository) {
        this.organizationRepository = organizationRepository;
        this.org_userRepository = orgUserRepository;
    }

    public Optional<Organization> save(Organization organization) {
        return organizationRepository.save(organization);
    }

    public List<Organization> getAll(){
        return null;
    }

    public Optional<Organization> findById(int id) {
        return organizationRepository.getOrganizationById(id);
    }

    public Optional<Organization> findByName(String name){
        return organizationRepository.getOrganizationByName(name);
    }

    public Optional<Organization> deleteById(int id) {
        return organizationRepository.delete(id);
    }

    public List<User> getAllUsersInOrganization(int id){
        Optional<Organization> optionalOrganization = organizationRepository.getOrganizationById(id);
        Organization org = optionalOrganization.isPresent() ? optionalOrganization.get() : null;
        List<User> users = this.org_userRepository.getUsersByOrganization(org);
        return users;
    }

    public Optional<User> addUserToOrganization(Org_User orgUser) {
        return org_userRepository.addUserToOrganization(orgUser);
    }

    public Optional<User> deleteUserFromOrganization(Org_User orgUser) {
        return org_userRepository.deleteUserFromOrganization(orgUser);
    }


}

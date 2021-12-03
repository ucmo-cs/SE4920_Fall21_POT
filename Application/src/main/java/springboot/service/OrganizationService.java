package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public Optional<Organization> save(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Transactional
    public List<Organization> getAll(){
        return this.organizationRepository.getAll();
    }

    @Transactional
    public Optional<Organization> findById(int id) {
        return organizationRepository.getOrganizationById(id);
    }

    @Transactional
    public List<Organization> findByName(String name){
        return organizationRepository.getOrganizationByName(name);
    }

    @Transactional
    public Optional<Organization> deleteById(int id) {
        return organizationRepository.delete(id);
    }

    @Transactional
    public List<User> getAllUsersInOrganization(int id){
        Optional<Organization> optionalOrganization = organizationRepository.getOrganizationById(id);
        Organization org = optionalOrganization.isPresent() ? optionalOrganization.get() : null;
        List<User> users = this.org_userRepository.getUsersByOrganizationId(org.getId());
        return users;
    }

    @Transactional
    public Optional<Org_User> addUserToOrganization(Org_User orgUser) {
        return org_userRepository.addUserToOrganization(orgUser);
    }

    @Transactional
    public Optional<User> deleteUserFromOrganization(Org_User orgUser) {
        return org_userRepository.deleteUserFromOrganization(orgUser);
    }

    @Transactional
    public List<Organization> getOrganizationByOwnerId(int id){
        return this.organizationRepository.getOrganizationByOwnerId(id);
    }

    @Transactional
    public Optional<Organization> updateOrganization(Organization org){
        return this.organizationRepository.update(org);
    }


}

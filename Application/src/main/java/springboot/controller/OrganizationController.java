package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Org_User;
import springboot.domain.Organization;
import springboot.domain.User;
import springboot.service.OrganizationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/organization/new")
    public Organization saveOrganization(@RequestBody Organization organization){
        Optional<Organization> optionalOrganization = organizationService.save(organization);
        return optionalOrganization.isPresent() ? optionalOrganization.get() : null;
    }

    @GetMapping("/organizations")
    public List<Organization> listAll(){
        List<Organization> list = new ArrayList<>();
        organizationService.getAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @GetMapping("/organization/{id}")
    public Organization getOne(@PathVariable int id){
        Optional<Organization> optionalOrganization = organizationService.findById(id);
        return optionalOrganization.isPresent() ? optionalOrganization.get() : null;
    }

    @GetMapping("/organization/owner/{id}")
    public Organization getByOwner(@PathVariable int id){
        Optional<Organization> optionalOrganization = organizationService.getOrganizationByOwnerId(id);
        return optionalOrganization.isPresent() ? optionalOrganization.get() : null;
    }

    @GetMapping("/organization/{id}/users")
    public List<User> getUsers(@PathVariable int id) {
        List<User> users = new ArrayList<>();
        organizationService.getAllUsersInOrganization(id).iterator().forEachRemaining(users::add);
        return users;
    }

    @GetMapping("/organization/{orgName}")
    public Organization getName(@PathVariable String orgName){
        Optional<Organization> optionalOrganization = organizationService.findByName(orgName);
        return optionalOrganization.isPresent() ? optionalOrganization.get() : null;
    }

    @PutMapping("/organization/{id}")
    public Organization update(@RequestBody Organization orgUpdate) {
        Optional<Organization> optionalOrganization = organizationService.findById(orgUpdate.getId());
        if (optionalOrganization.isPresent()) {
            organizationService.save(orgUpdate);
        }
        return orgUpdate;
    }

    @PutMapping("/organization/user/add")
    public void addUserToOrganization(@RequestBody Org_User orgUser) {
        organizationService.addUserToOrganization(orgUser);
    }

    @DeleteMapping("/organization/{id}")
    public void delete(@PathVariable int id) {
        organizationService.deleteById(id);
    }

    @DeleteMapping("/organization/user/remove")
    public void removeUserFromOrganization(@RequestBody Org_User orgUser) {
        organizationService.deleteUserFromOrganization(orgUser);
    }

}

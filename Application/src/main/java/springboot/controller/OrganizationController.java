package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Org_User;
import springboot.domain.Organization;
import springboot.domain.User;
import springboot.service.OrganizationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @CrossOrigin
    @PostMapping("/organization")
    public ResponseEntity<?> saveOrganization(@RequestBody Organization organization){
        //Optional<Organization> optionalOrganization = organizationService.save(organization);
        //ResponseEntity<> response = (data,status)
        //return optionalOrganization.isPresent() ? optionalOrganization.get() : null;
        System.out.println("testing post");

        return new ResponseEntity<>(organizationService.save(organization), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/organization")
    public ResponseEntity<?> listAll(){
//        List<Organization> list = new ArrayList<>();
//        organizationService.getAll().iterator().forEachRemaining(list::add);

        return new ResponseEntity<>(organizationService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/organization/{id}")
    public Organization getOne(@PathVariable int id){
        Optional<Organization> optionalOrganization = organizationService.findById(id);
        return optionalOrganization.isPresent() ? optionalOrganization.get() : null;
    }

    @CrossOrigin
    @GetMapping("/organization/owner/{id}")
    public List<Organization> getByOwner(@PathVariable int id){
        List<Organization> org = organizationService.getOrganizationByOwnerId(id);
        return org;
    }

    @CrossOrigin
    @GetMapping("/organization/{id}/users")
    public List<User> getUsers(@PathVariable int id) {
        List<User> users = new ArrayList<>();
        organizationService.getAllUsersInOrganization(id).iterator().forEachRemaining(users::add);
        return users;
    }

    @CrossOrigin
    @GetMapping("/organization/{orgName}")
    public List<Organization> getName(@PathVariable String orgName){
        List<Organization> org = organizationService.findByName(orgName);
        return org;
    }

    @CrossOrigin
    @PostMapping("/organization/{id}")
    public Organization update(@RequestBody Organization orgUpdate) {
        Optional<Organization> optionalOrganization = organizationService.findById(orgUpdate.getId());
        if (optionalOrganization.isPresent()) {
            organizationService.save(orgUpdate);
        }
        return orgUpdate;
    }

    @CrossOrigin
    @PostMapping("/organization/user")
    public void addUserToOrganization(@RequestBody Org_User orgUser) {
        organizationService.addUserToOrganization(orgUser);
    }

    @CrossOrigin
    @DeleteMapping("/organization/{id}")
    public void delete(@PathVariable int id) {
        organizationService.deleteById(id);
    }

    @CrossOrigin
    @DeleteMapping("/organization/user")
    public void removeUserFromOrganization(@RequestBody Org_User orgUser) {
        organizationService.deleteUserFromOrganization(orgUser);
    }

}

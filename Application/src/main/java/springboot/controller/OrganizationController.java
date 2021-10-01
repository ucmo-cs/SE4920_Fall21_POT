package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public Organization saveOrganization(@RequestBody Organization organization){
        return organizationService.save(organization);
    }

    @GetMapping
    public List<Organization> listAllOrganizations(){
        List<Organization> list = new ArrayList<>();
        organizationService.getAll();
        return list;
    }

    @GetMapping("/organization/{id}")
    public Organization getOne(@PathVariable int id){
        Optional<Organization> optionalOrganization = organizationService.findById(id);
        return optionalOrganization.isPresent() ? optionalOrganization.get() : null;
    }

    @GetMapping("/organization/{id}/users")
    public List<User> getUsers(@PathVariable int id) {
        return organizationService.getAllUsersInOrganization(id);
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        organizationService.deleteById(id);
     }
}
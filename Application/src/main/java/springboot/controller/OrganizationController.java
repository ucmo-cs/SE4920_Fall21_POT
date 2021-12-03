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
        Optional<Organization> opt = organizationService.save(organization);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(opt, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/organization")
    public ResponseEntity<?> listAll(){
        List<Organization> list = organizationService.getAll();
        if(list.size()==0){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/organization/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id){
        Optional<Organization> opt = organizationService.findById(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/organization/owner/{id}")
    public ResponseEntity<?> getByOwner(@PathVariable int id){
        List<Organization> list = organizationService.getOrganizationByOwnerId(id);
        if(list.size()==0){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @CrossOrigin
//    @GetMapping("/organization/{orgName}")
//    public ResponseEntity<?> getByName(@PathVariable String orgName){
//        List<Organization> list = organizationService.findByName(orgName);
//        if(list.size()==0){
//            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }

    @CrossOrigin
    @GetMapping("/organization/{id}/users")
    public ResponseEntity<?> getUsers(@PathVariable int id) {
        List<User> list = organizationService.getAllUsersInOrganization(id);
        if(list.size()==0){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @PatchMapping("/organization/{id}")
    public ResponseEntity<?> update(@RequestBody Organization orgUpdate) {
        Optional<Organization> opt = organizationService.updateOrganization(orgUpdate);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(opt, HttpStatus.ACCEPTED);

    }

    @CrossOrigin
    @DeleteMapping("/organization/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Organization> opt = organizationService.deleteById(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @PostMapping("/organization/user")
    public ResponseEntity<?> addUserToOrganization(@RequestBody Org_User orgUser) {
        System.out.println(orgUser);
        Optional<Org_User> opt = organizationService.addUserToOrganization(orgUser);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(opt, HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @DeleteMapping("/organization/user")
    public ResponseEntity<?> removeUserFromOrganization(@RequestBody Org_User orgUser) {
        Optional<User> opt = organizationService.deleteUserFromOrganization(orgUser);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.ACCEPTED);
    }

}

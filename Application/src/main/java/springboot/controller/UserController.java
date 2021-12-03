package springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springboot.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credentials creds) {
        if(!userService.validateLogin(creds)){
            return new ResponseEntity<>(false, HttpStatus.NOT_ACCEPTABLE);
        }
        int id = userService.findByEmail(creds.getEmail()).get().getId();
        return new ResponseEntity<>(id, HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @GetMapping("/users")
    public ResponseEntity<?> listUsers() {
        List<User> list = userService.findAll();
        if(list.size()==0){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        Optional<User> opt = userService.save(user);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(opt, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id) {
        Optional<User> opt = userService.findById(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        System.out.println(opt.get());
        return new ResponseEntity<>(opt, HttpStatus.OK);
    }

//    @CrossOrigin
//    @GetMapping("/user/{username}")
//    public ResponseEntity<?> getUser(@PathVariable String username) {
//        Optional<User> opt = userService.findByUsername(username);
//        if(!opt.isPresent()){
//            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(opt, HttpStatus.OK);
//    }

    @CrossOrigin
    @GetMapping("/user/{id}/organization")
    public ResponseEntity<?> getOrganization(@PathVariable int id){
        Optional<Organization> opt = userService.getOrganizationByUserId(id);
        if(opt!=null){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.OK);

    }

    @CrossOrigin
    @GetMapping("/user/{id}/supervisor")
    public ResponseEntity<?> getSupervisor(@PathVariable int id){
        Optional<User> optU = userService.findById(id);
        User user = optU.isPresent() ? optU.get() : null;
        if(user==null){
            return new ResponseEntity<>(optU, HttpStatus.NOT_FOUND);
        }
        Optional<User> optS = userService.getSupervisorOfId(user.getId());
        if(!optS.isPresent()){
            return new ResponseEntity<>(optS, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/user/{id}/subordinates")
    public ResponseEntity<?> getSubordinates(@PathVariable int id){
        Optional<User> optU = userService.findById(id);
        User user = optU.isPresent() ? optU.get() : null;
        if(user==null){
            return new ResponseEntity<>(optU, HttpStatus.NOT_FOUND);
        }
        List<User> list = userService.getSubordinatesOfId(user.getId());
        if(list.size()==0){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/user/{id}")
    public ResponseEntity<?> update(@RequestBody User userUpdate) {
        Optional<User> opt = userService.update(userUpdate);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/subordinate")
    public ResponseEntity<?> addSubordinate(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        List<User> list = userService.addSubordinate(supervisorSubordinate);
        if(list.size()==0){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/supervisor")
    public ResponseEntity<?> addSupervisor(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        Optional<User> opt = userService.addSupervisor(supervisorSubordinate);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<User> opt = userService.deleteById(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @DeleteMapping("/subordinate")
    public ResponseEntity<?> deleteSubordinate(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        List<User> list = userService.deleteSubordinate(supervisorSubordinate);
        if(list.size()==0){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @DeleteMapping("/supervisor")
    public ResponseEntity<?> deleteSupervisor(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        Optional<User> opt = userService.deleteSupervisor(supervisorSubordinate);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.ACCEPTED);
    }




}


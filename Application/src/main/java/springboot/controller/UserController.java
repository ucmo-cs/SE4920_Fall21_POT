package springboot.controller;

import springboot.domain.Organization;
import springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> listUsers() {
        List<User> list = new ArrayList<>();
        userService.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @GetMapping("/user/{id}")
    public User getOne(@PathVariable int id) {
        Optional<User> optionalUser = userService.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        Optional<User> optionalUser = userService.findByUsername(username);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @GetMapping("/user/{id}/organization")
    public Organization getOrganization(@PathVariable int id){
        Optional<User> optionalUser = userService.findById(id);
        User user = optionalUser.isPresent() ? optionalUser.get() : null;
        Optional<Organization> optionalOrganization = userService.getOrganizationByUserId(user.getId());
        return optionalOrganization.isPresent() ? optionalOrganization.get() : null;
    }

    @PutMapping("/user/{id}")
    public User update(@RequestBody User userUpdate) {
        Optional<User> optionalUser = userService.findById(userUpdate.getId());
        if (optionalUser.isPresent()) {
            userService.save(userUpdate);
        }
        return userUpdate;
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteById(id);
    }


}


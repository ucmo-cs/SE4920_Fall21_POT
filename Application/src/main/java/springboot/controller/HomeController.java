package springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    //Response Entity represents the whole HTTP response : status code, headers, and body

    @GetMapping(value = "/")
    public ResponseEntity<?> index() {
        return new ResponseEntity<String>("Ok", HttpStatus.OK);
    }
}

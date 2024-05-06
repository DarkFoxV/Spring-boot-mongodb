package com.io.darkfoxv.application.resources;

import com.io.darkfoxv.application.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>>  findAll() {
        User maria = new User("1", "Maria", "Maria@gmail.com");
        User mario = new User("2", "Mario", "Mario@gmail.com");
        return ResponseEntity.ok().body(new ArrayList<>(Arrays.asList(maria, mario)));

    }
}

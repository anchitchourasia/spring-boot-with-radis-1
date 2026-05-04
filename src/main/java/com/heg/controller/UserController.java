package com.heg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heg.model.User;
import com.heg.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	// CREATE SINGLE USER
    @PostMapping
    public User create(@RequestBody User user) {
        return service.saveUser(user);
    }

    // GET USER
    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.getUser(id);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "Deleted";
    }


}

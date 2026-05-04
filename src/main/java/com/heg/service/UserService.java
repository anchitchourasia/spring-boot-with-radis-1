package com.heg.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.heg.model.User;

@Service
public class UserService {
	private Map<Long,User> fakeDB= new HashMap();
	
	// CREATE / UPDATE
    @CachePut(value = "users", key = "#user.id")
    public User saveUser(User user) {
        fakeDB.put(user.getId(), user);
        System.out.println("Saved in fakeDB: " + user.getId());
        return user;
    }
    
 

    // READ
    @Cacheable(value = "users", key = "#id", unless = "#result == null")
    public User getUser(Long id) {
        System.out.println("Fetching from fakeDB...");
        return fakeDB.get(id);
    }

    // DELETE
    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Long id) {
        fakeDB.remove(id);
        System.out.println("Deleted from fakeDB: " + id);
    }

    
	

}

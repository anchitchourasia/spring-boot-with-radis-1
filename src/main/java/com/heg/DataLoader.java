package com.heg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heg.model.User;
import com.heg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("data.json");
        List<User> users = mapper.readValue(resource.getInputStream(),
                new TypeReference<List<User>>() {});
        for (User user : users) {
            userService.saveUser(user);
        }
        System.out.println("✅ Dummy data loaded from data.json: " + users.size() + " users");
    }
}
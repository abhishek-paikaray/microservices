package com.user.Controller;

import com.user.entity.User;
import com.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId)
    {
        User user= this.userService.getUser(userId);

       List contact= this.restTemplate.getForObject("http://contact-service/contact/user/"+user.getUserId(), List.class);

        user.setContacts(contact);

        return user;
    }
}

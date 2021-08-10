package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    //fake service

    List<User> list= List.of(

            new User(1311L,"Abhishek Paikaray","99005500"),
            new User(1312L,"Prachi Agarwal","88554422"),
            new User(1314L,"Anish","11002233")



    );


    @Override
    public User getUser(Long id) {
        return this.list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }
}

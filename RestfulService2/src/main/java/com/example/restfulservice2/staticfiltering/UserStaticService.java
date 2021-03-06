package com.example.restfulservice2.staticfiltering;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserStaticService {
    public static List<UserStatic> users = new ArrayList<>();
    public static int count = 2;
    static {
        users.add(new UserStatic(1 , "Lavanya" , "lavanya@gmail.com" , "lavanya"));
        users.add(new UserStatic(2 , "Arnav" , "arnav@gmail.com" , "arnav"));

    }

    public List<UserStatic> findAll() {
        return users;
    }

    public UserStatic saveContacts(UserStatic user){
        if(user.getId() == null){
            user.setId(++count);
        }
        users.add(user);
        return user;
    }

    public UserStatic findOne(int id){
        for(UserStatic user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}

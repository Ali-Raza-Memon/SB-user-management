package com.UserManagementApp.controller;

import com.UserManagementApp.model.User;
import com.UserManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user1){


        System.out.println(user1 );

        boolean f = userService.checkEmail(user1.getEmail());

        if(f){
            System.out.println("Email id alrady Exist");
        }else{

            User user2 = userService.createUser(user1);
            if(user2 !=null){
                System.out.println("Registered Successfully");
            }else{
                System.out.println("Something went wrong in servor");
            }
        }




        return "redirect:/register";
    }






}

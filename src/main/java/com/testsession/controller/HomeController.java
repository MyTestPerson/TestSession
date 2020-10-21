package com.testsession.controller;

import com.testsession.model.User;
import com.testsession.service.ActiveUserService;
import com.testsession.service.UserServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {


    @Autowired
    UserServiceJpa userServiceJpa;


    @Autowired
    ActiveUserService activeUserService;


    @GetMapping(value = "/")
    public String homePage () {
            return "/home";
    }


    @GetMapping(value = "/login")
    public String loginPageGet () {
        return "/login";
    }


    @PostMapping(value = "/login")
    public String loginPost () {
        return "redirect:/";
    }


    @GetMapping(value = "/user")
    public String addUserPage () {
        return "/user";
    }


    @PostMapping("/user")
    public String addUserPost(@ModelAttribute("user") User user){
        userServiceJpa.save(user);
        return "redirect:/user";
    }


    @GetMapping(value = "/allUser")
    public ModelAndView AllUserPage () {

        List<String > allActiveUsers = activeUserService.getAllActiveUser();
        Iterable<User> users = allActiveUsers.stream().map(User::new).collect(Collectors.toList());

        return new ModelAndView("/allUser", "user", users);

    }


}

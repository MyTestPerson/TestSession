package com.testsession.controller;

import com.testsession.model.User;
import com.testsession.service.ActiveUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final
    ActiveUserService activeUserService;

    public HomeController(ActiveUserService activeUserService) {
        this.activeUserService = activeUserService;
    }


    @GetMapping(value = "/")
    public String homePage () {
            return "/home";
    }




    @PostMapping(value = "/login")
    public String loginPost () {
        return "redirect:/";
    }


    @GetMapping(value = "/user")
    public ModelAndView addUserPage () {

        List<String > allActiveUsers = activeUserService.getAllActiveUser();
        Iterable<User> users = allActiveUsers
                .stream().map(User::new).collect(Collectors.toList());

        return new ModelAndView("/user", "user", users);
    }


}

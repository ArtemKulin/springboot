package ru.kulinartem.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kulinartem.springboot.service.UserService;


@Controller
@RequestMapping("/user")
public class Users {

    private final UserService user;

    @Autowired
    public Users(@Qualifier("UserServiceImpl") UserService user) {
        this.user = user;
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) throws Exception {
        model.addAttribute("user", user.getItemById(id));
        return "user/user";
    }
}

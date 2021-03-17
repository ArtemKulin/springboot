package ru.kulinartem.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kulinartem.springboot.entity.User;
import ru.kulinartem.springboot.service.RoleService;
import ru.kulinartem.springboot.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class Admins {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Admins(@Qualifier("UserServiceImpl") UserService userService, @Qualifier("RoleServiceImpl") RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAdminRootPage(@ModelAttribute("newUser") User newUser, Model model, Principal principal) {
        String name = principal.getName();
        User user = userService.getItemByEmail(name);
        model.addAttribute("currentUser", user);
        model.addAttribute("users", userService.getAllItems());
        model.addAttribute("roles", roleService.getAllItems());
        return "admin/users";
    }

    @GetMapping("/users")
    public String showAllUsersPage(@ModelAttribute("newUser") User newUser, Model model, Principal principal) {
        String name = principal.getName();
        User user = userService.getItemByEmail(name);
        model.addAttribute("currentUser", user);
        model.addAttribute("users", userService.getAllItems());
        model.addAttribute("roles", roleService.getAllItems());
        return "admin/users";
    }

    @GetMapping("/{id}")
    public String showUserPage(@PathVariable("id") long id, Model model) throws Exception {
        model.addAttribute("user", userService.getItemById(id));
        return "admin/user";
    }

    @GetMapping("/new")
    public String showNewUserPage(@ModelAttribute("newUser") User newUser, Model model) {
        model.addAttribute("roles", roleService.getAllItems());
        return "admin/newUser";
    }

    @PostMapping("/users")
    public String createNewUser(@ModelAttribute("newUser") User newUser, Model model) {
        newUser.setPassword(new BCryptPasswordEncoder(12).encode(newUser.getPassword()));
        userService.saveItem(newUser);
        return "redirect:/admin/";
    }

    @GetMapping("/{id}/edit")
    public String showEditUserPage(@PathVariable("id") long id, Model model) throws Exception {
        model.addAttribute("user", userService.getItemById(id));
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User editedUser, @PathVariable("id") long id) throws UsernameNotFoundException {
        userService.updateItem(editedUser, id);
        return "redirect:/admin/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("user") User deletedUser) {
        userService.deleteItem(deletedUser);
        return "redirect:/admin/";
    }
}

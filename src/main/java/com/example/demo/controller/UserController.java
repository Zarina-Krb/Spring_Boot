package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String add(@RequestParam("name") String name, @RequestParam("lastName") String lastName,
                      @RequestParam("age") int age) {
        userService.add(new User(name, lastName, age));
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String addUser() {
        return "add-user";
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/findById")
    public String findById(@RequestParam("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "users";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("lastName") String lastName,
                         @RequestParam("age") int age) {
        User user = new User(name, lastName, age);
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}

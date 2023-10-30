package com.viachaslausviatski.pet_project.controller;

import com.viachaslausviatski.pet_project.entity.User;
import com.viachaslausviatski.pet_project.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registartion(User user, Model model) {
        if(user.getEmail() == null || user.getEmail().isEmpty()) {
            model.addAttribute("errorMessage", "Email не может быть пустым");
            return "registration";
        }
        if(!userService.createUser(user)) {
            model.addAttribute("errorMessage","Пользователь с email: " + user.getEmail() +
                    " уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @PostMapping("/hello")
    public String securityUrl() {
        return "hello";
    }
}

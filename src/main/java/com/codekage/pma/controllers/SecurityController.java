package com.codekage.pma.controllers;

import com.codekage.pma.dto.UserOut;
import com.codekage.pma.entities.UserAccount;
import com.codekage.pma.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class SecurityController {

    final UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String registerUser(Model model, UserAccount user){
        UserOut userOut = userService.RegisterUser(user);
        return "redirect:/";
    }

    @GetMapping
    public String displayRegister(Model model){
        UserAccount user = new UserAccount();
        model.addAttribute("userAccount", user);
        return "security/register";
    }
}

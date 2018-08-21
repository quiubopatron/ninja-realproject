package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.UserCredential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    public static final String LOGIN = "login";
    public static final String CONTACTS = "contacts";

    @GetMapping
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, @RequestParam(name="error", defaultValue = "", required = false) String error) {

        model.addAttribute("error", error);
        model.addAttribute("userCredential", new UserCredential());

        return LOGIN;
    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name = "userCredential")UserCredential userCredentials) {

        if(userCredentials.getUsername().equals("user") && userCredentials.getPassword().equals("user")) {

            return CONTACTS;

        }

        return "redirect:/login?error";
    }

}

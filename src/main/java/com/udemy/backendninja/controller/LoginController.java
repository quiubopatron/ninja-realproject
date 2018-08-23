package com.udemy.backendninja.controller;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.UserCredential;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Log log = LogFactory.getLog(LoginController.class);

    @GetMapping
    public String redirectToLogin() {
        log.info("METHOD: redirectToLogin()");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, @RequestParam(name="error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout) {

        log.info("METHOD: showLoginForm() -- PARAMS: error: " + error + ". logout: " + logout );

        model.addAttribute("error", error);
        model.addAttribute("userCredential", new UserCredential());
        model.addAttribute("logout", logout);

        log.info("Returning to login view");

        return ViewConstant.LOGIN;

    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name = "userCredential")UserCredential userCredentials) {

        log.info("METHOD: loginCheck() -- PARAMS: userCredentials: " + userCredentials.toString());

        if(userCredentials.getUsername().equals("user") && userCredentials.getPassword().equals("user")) {

            log.info("Returning to login contacts");
            return "redirect:/contacts/listcontacts";

        }

        log.info("Returning to login login?error");

        return "redirect:/login?error";
    }

}

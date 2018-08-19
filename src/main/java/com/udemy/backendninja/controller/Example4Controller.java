package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/example4")
public class Example4Controller {

    @GetMapping("/error")
    public String mostrarError(Model model) {
        return "404";
    }

}

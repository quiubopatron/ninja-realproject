package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class example2Controller {

    public static final String EXAMPLE_2 = "example2";

    // Ejemplo peticion get
    // localhost:8080/example2/request1?nm=pepe&age=pepe2
    @GetMapping("/request1")
    public ModelAndView request(@RequestParam(name="nm", required = false, defaultValue = "null") String name) {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_2);
        modelAndView.addObject("nm_in_model", name);
        return modelAndView;
    }

    @GetMapping("/request2/{nm}")
    public ModelAndView request2(@PathVariable("nm") String name) {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_2);
        modelAndView.addObject("nm_in_model", name);
        return modelAndView;
    }


}


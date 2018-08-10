package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";
    // Primeraforma
    @RequestMapping(value = "/exampleString", method = RequestMethod.GET)
    public String exampleString(Model model) {
        model.addAttribute("person", new Person("Luis", 25));
        return EXAMPLE_VIEW;

    }

    // Segunda forma
    @GetMapping("/examplemav")
    public ModelAndView exampleMAV(){

        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        modelAndView.addObject("person", new Person("Peep", 50));
        return modelAndView;

//        return new ModelAndView(EXAMPLE_VIEW);
    };
}

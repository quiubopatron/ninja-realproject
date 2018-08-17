package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// Ejemplo de formulario
@Controller
@RequestMapping("/example3")
public class example3Controller {

    public static final String FORM = "form";

    // Llamada a la vista form. Pasamos en el modelo un objeto person no inicializado
    @GetMapping("/showform")
    public String mostrarFormulario(Model model) {
        model.addAttribute("persona", new Person("cucu", 34));

        return  FORM;
    }

    // Llamada al clicar boton submit. Ejemplo petición post.
    @PostMapping("/addperson")
    public ModelAndView addperson(@ModelAttribute("person") Person person) { // Capturamos el atributo persona mediante @ModelAttribute y lo insertamos en el modelo de la vista

        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("person", person);
        return modelAndView;
    }
}

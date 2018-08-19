package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

// Ejemplo de formulario
@Controller
@RequestMapping("/example3")
public class Example3Controller {

    public static final String FORM = "form";

    // Llamada a la vista form. Pasamos en el modelo un objeto person no inicializado
    @GetMapping("/showform")
    public String mostrarFormulario(Model model) {
        model.addAttribute("person", new Person());

        return  FORM;
    }

    // Llamada al clicar boton submit. Ejemplo petición post.
    @PostMapping("/addperson")
    public ModelAndView addperson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) { // Capturamos el atributo persona mediante @ModelAttribute y lo insertamos en el modelo de la vista. @Valid valdiara según las anotaciones que hemos puesto en el modelo, en este caso sobre persona. Y annadir bindingResult que lo usara Spring para validar los datos

        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()){

            modelAndView.setViewName("form");
            modelAndView.addObject("person", person);

        } else {

            modelAndView.setViewName("result");
        }

        return modelAndView;
    }
}

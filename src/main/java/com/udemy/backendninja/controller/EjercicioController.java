package com.udemy.backendninja.controller;

import com.udemy.backendninja.component.RequestTimeInterceptor;
import com.udemy.backendninja.service.EjercicioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Autoevaluación - Checkpoint I
 Sección 5, Clase 35
 Ya estás cada vez más cerca de tu objetivo, Ninja  :)



 Te aconsejo no fijarte mucho en los ejemplos que hemos visto hasta ahora, es importante que te pegues un poco con el código, sólo así aprenderás de verdad.

 Para comprobar tus verdaderos conocimientos intenta resolver este ejercicio:

 Implementar un controlador que responda a la petición 'http://localhost:8080/ejercicio/'. Este controlador estará compuesto por dos métodos con el path que quieras.
 Crea un servicio de un sólo método que muestre un mensaje de log con Apache Commons.
 Utiliza las anotaciones y todo lo aprendido durante esta parte del curso para que el primer método del controlador redireccione al segundo.
 En el segundo método del controlador deberemos invocar al método del servicio creado en el punto 2, previa inyección de dependencias, ademas de insertar en la vista de retorno una cadena de caracteres cuyo nombre es 'mensaje'.
 Añade un log en el segundo método del controlador para calcular el tiempo que ha tardado la petición en ser respondida.
 Crea una plantilla donde se muestre el mensaje enviado desde el controlador.
 ¿Dudas? Pregúntame lo que necesites.
 */

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

    private Log log = LogFactory.getLog(EjercicioController.class);

    @Autowired
    @Qualifier("ejercicioService")
    private EjercicioService ejercicioService;

    @Autowired
    @Qualifier("requestTimeInterceptor")
    private RequestTimeInterceptor requestTimeInterceptor;

    @GetMapping("/uno")
    public String metodoUno() {
        ModelAndView modelAndView = new ModelAndView();
        return "redirect:/ejercicio/dos";
    }

    @GetMapping("/dos")
    public ModelAndView metodoDos() {
        ModelAndView modelAndView = new ModelAndView("ejercicio");
        modelAndView.addObject("mensaje", "Ejercicio resuleto ;)");
        ejercicioService.pintarLog();
        return modelAndView;
    }


}

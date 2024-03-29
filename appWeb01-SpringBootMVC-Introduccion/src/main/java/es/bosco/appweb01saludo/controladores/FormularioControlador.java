package es.bosco.appweb01saludo.controladores;

import es.bosco.modelo.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormularioControlador {

    @GetMapping("/formulario")  //ir al formulario para la entrada de datos
    public String mostrarFormulario(Model model) {
        model.addAttribute("datos", new Persona());  //datos es  el objeto "vehículo" de transporte. (Va instanciado)
        return "formularioEntrada";
    }

    @PostMapping("/procesar") //simplemente pasamos la persona recibida a formularioSalida
    public String procesarFormulario(@ModelAttribute Persona persona, Model model) {
        // Realizar acciones con los datos, como almacenarlos en una base de datos.
        // En este ejemplo, simplemente los pasamos a la página de salida.
        model.addAttribute("datos", persona);
        return "formularioSalida";
    }

}

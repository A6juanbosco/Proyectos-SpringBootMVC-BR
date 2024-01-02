package es.bosco.appweb01saludo.controladores;

import es.bosco.modelo.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormularioControlador {

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("datos", new Persona());  //datos es  el objeto "vehículo" de transporte. (Va instanciado)
        return "formularioEntrada";
    }

    @PostMapping("/procesar")
    public String procesarFormulario(@ModelAttribute Persona persona, Model model) {
        // Aquí podrías realizar acciones con los datos, como almacenarlos en una base de datos.
        // En este ejemplo, simplemente los pasamos a la página de salida.
        model.addAttribute("datos", persona);
        return "formularioSalida";
    }
    @GetMapping("/salida")
    public String mostrarSalida(@ModelAttribute Persona datos, Model model) {
        model.addAttribute("datos", datos);
        return "formularioSalida";
    }
}

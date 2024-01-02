package es.bosco.appweb01saludo.controladores;

import es.bosco.appweb01saludo.servicios.EmpleadoService;
import es.bosco.appweb01saludo.modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/empleado")
public class EmpleadoControlador {

    @Autowired
    private EmpleadoService servicio;


    @GetMapping({"/", "/list"})
    public String listado(Model model) {
        model.addAttribute("listaEmpleados", servicio.findAll());
        return "listaEmpleados";
    }

    @GetMapping("/nuevo")
    public String nuevoEmpleadoForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        //return "hola";
        return "nuevoEmpleado";
    }

    @PostMapping("/nuevo/enviar")
    public String nuevoEmpleadoEnviar(@ModelAttribute("empleado") Empleado nuevoEmpleado) {
        servicio.add(nuevoEmpleado);
        return "redirect:/empleado/list";
    }
    @GetMapping("/editar")
    public String editarEmpleadoForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        //return "hola";
        return "nuevoEmpleado";
    }

}

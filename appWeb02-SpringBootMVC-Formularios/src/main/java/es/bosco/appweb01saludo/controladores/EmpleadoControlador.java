package es.bosco.appweb01saludo.controladores;

import es.bosco.appweb01saludo.modelo.Empleado;
import es.bosco.appweb01saludo.servicios.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping({"/","/empleado"})
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
    public String nuevoEmpleadoEnviar(@ModelAttribute Empleado empleado) {
        servicio.add(empleado);
        return "redirect:/empleado/list";
    }

    @GetMapping("/editar/{id}")
    public String editarEmpleadoForm(@PathVariable long id, Model model) {
        Empleado empleado = servicio.findById(id);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "nuevoEmpleado";
        } else {
            model.addAttribute("empleado", empleado);
            return "redirect:/empleado/nuevo/enviar";
        }
    }


    @PostMapping("/editar/enviar")
    public String editarEmpleadoEnviar(@ModelAttribute Empleado empleado) {
        servicio.editar(empleado);
        return "redirect:/empleado/list";
    }

}

package es.bosco.appweb01saludo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaludosControlador {

    //http://localhost:9001/
    @GetMapping("/")
    public String saludo() {
        return "saludoHolaMundo";

    }

    //http://localhost:9001/saludo
    @GetMapping("/saludo")
    public String saludoModel(Model modelo) {
        String saludo="Hola Mundo desde SpringBoot MVC (Model)";
        modelo.addAttribute("mensaje", saludo);
        return "saludoModel";

    }
    //localhost:9001/saludoParametro?nombre=Pepe

    //@GetMapping("/saludoParametro")
    //public String saludoRequestParam(@RequestParam String nombre, Model modelo){

    //@GetMapping("/saludoParametro")
    //public String saludoRequestParam(@RequestParam("nombre") String nombre, Model modelo){

    @GetMapping("/saludoParametro")
    public String saludoRequestParam(@RequestParam(name="nombre", required = false,defaultValue = "Mundo") String nombre, Model modelo){
        String saludo ="Hola " + nombre;
        modelo.addAttribute("mensaje", saludo);
        return "saludoModel";
    }

    //http://localhost:9001/contacto
    @GetMapping("/contacto")
    public String contacot(Model modelo) {
        String contacto="Contacto. A través del email bautista@iesjuanbosco.es";
        modelo.addAttribute("mensaje", contacto);
        return "saludoModel";
    }
    //http://localhost:9001/presentacion
    @GetMapping("/presentacion")
    public String presentacion(Model modelo) {
        String presentacion="Presentación. Me llamo Bautista y vivo en Miguel Esteban";
        modelo.addAttribute("mensaje", presentacion);
        return "saludoModel";
    }

    //http://localhost:9001/saludoVariable/Pepe
    @GetMapping("/saludoVariable/{nombre}")
    public String saludoPathVariable(@PathVariable String nombre, Model modelo){
       // public String saludoPathVariable(@PathVariable(name="nombre") String nombre, Model modelo){
        String saludo ="Hola " + nombre;
        modelo.addAttribute("mensaje", saludo);
        return "saludoModel";
    }

    //EJERCICIO
    //localhost:9001/saludoParametros?nombre=Pepe&apellidos=Lara Carrasco
    @GetMapping("/saludoParametros")
    public String saludoRequestParamEj01(@RequestParam String nombre, @RequestParam String apellidos, Model modelo){
        String saludo ="Hola " + nombre +" " + apellidos;
        modelo.addAttribute("mensaje", saludo);
        return "saludoModel";
    }
    //http://localhost:9001/saludoVariables/Pepe/Lara
    @GetMapping("/saludoVariables/{nombre}/{apellidos}")
    public String saludoPathVariableEj02(@PathVariable String nombre, @PathVariable String apellidos, Model modelo){
        String saludo ="Hola " + nombre + " " + apellidos;
        modelo.addAttribute("mensaje", saludo);
        return "saludoModel";
    }


}
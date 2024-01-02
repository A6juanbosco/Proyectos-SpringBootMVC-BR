package es.bosco.appweb01saludo.servicios;


import es.bosco.appweb01saludo.modelo.Empleado;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpleadoService {

    private List<Empleado> repositorio = new ArrayList<>();


    public Empleado add(Empleado e) {
        repositorio.add(e);
        return e;
    }

    public Empleado findById(long id) {
        boolean encontrado = false;
        int cont = 0;
        Empleado e = null;
        while (!encontrado && cont < repositorio.size()) {
            if (repositorio.get(cont).getId() == id) {  //si encontrado
                encontrado = true;
                e = repositorio.get(cont);
            }
            cont++;
        }
        return e;
    }

    public void editar(Empleado e) {
        boolean encontrado = false;
        for (Empleado empleado : repositorio) {
            if (empleado.getId() == e.getId()) {
                empleado.setEmail(e.getEmail());
                empleado.setNombre(e.getNombre());
                empleado.setTelefono(e.getTelefono());
                //repositorio.remove(e);
                //repositorio.add(e);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            repositorio.add(e);
        }
    }

    public List<Empleado> findAll() {
        return repositorio;
    }

    @PostConstruct
    public void init() {
        repositorio.addAll(
                Arrays.asList(new Empleado(1, "Antonio García", "antonio.garcia@openwebinars.net", "954000000"),
                        new Empleado(2, "María López", "maria.lopez@openwebinars.net", "954000000"),
                        new Empleado(3, "Ángel Antúnez", "angel.antunez@openwebinars.net", "954000000")
                )
        );
    }

}

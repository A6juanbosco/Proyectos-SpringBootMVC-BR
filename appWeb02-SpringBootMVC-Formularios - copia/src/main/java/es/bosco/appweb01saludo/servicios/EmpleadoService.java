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

    public boolean editar(long id, Empleado eMofif) {
        boolean modificado = false;
        for (Empleado e : repositorio) {
            if (e.getId() == id) {
                repositorio.remove(eMofif);
                repositorio.add(eMofif);
                modificado=true;
                break;
            }
        }
        return modificado;
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

package co.edu.unicauca.CSAlertas.core.controllers;

import co.edu.unicauca.CSAlertas.core.models.LecturaDTO;
import co.edu.unicauca.CSAlertas.core.services.IlecturaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class LecturaRestController {
    @Autowired
    private IlecturaService lecturaServices;

    @GetMapping("/lecturas")
	public List<LecturaDTO> index() {
		return lecturaServices.findAll();
	}

    @GetMapping("/lecturas/{zona}")
    public List<LecturaDTO> index(@PathVariable String zona){
        return lecturaServices.findByZona(zona);
    }

    @PostMapping("/lecturas")
    public LecturaDTO create(@RequestBody LecturaDTO lectura){
        LecturaDTO objLectura = null;
        objLectura = lecturaServices.save(lectura);
        return objLectura;
    }
}

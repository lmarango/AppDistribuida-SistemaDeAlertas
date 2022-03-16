package co.edu.unicauca.CSAlertas.core.services;

import co.edu.unicauca.CSAlertas.core.models.LecturaDTO;
import co.edu.unicauca.CSAlertas.core.repositories.LecturaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturaServiceImpl implements IlecturaService {
    @Autowired
    private LecturaRepository servicioAccesoBaseDeDatos;

    @Override
    public List<LecturaDTO> findAll() {		
	return this.servicioAccesoBaseDeDatos.findAll();
    }

    @Override
    public List<LecturaDTO> findByZona(String prmZona) {
        return this.servicioAccesoBaseDeDatos.findByZona(prmZona);
    }

    @Override
    public LecturaDTO save(LecturaDTO prmLectura) {
        return this.servicioAccesoBaseDeDatos.save(prmLectura);
    }
    
}

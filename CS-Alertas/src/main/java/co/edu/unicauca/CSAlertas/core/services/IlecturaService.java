package co.edu.unicauca.CSAlertas.core.services;

import co.edu.unicauca.CSAlertas.core.models.LecturaDTO;
import java.util.List;

public interface IlecturaService {
    public List<LecturaDTO> findAll();
    public List<LecturaDTO> findByZona(String prmZona);
    public LecturaDTO save(LecturaDTO prmLectura);
}

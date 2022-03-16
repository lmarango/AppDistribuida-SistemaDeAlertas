package co.edu.unicauca.CSAlertas.core.services;

import co.edu.unicauca.CSAlertas.core.models.LecturaDTO;
import java.util.List;

/**
 *
 * @author User
 */
public interface INotificacionService {
    public void enviarNotificacion(List<LecturaDTO> prmLstLecturas);
}

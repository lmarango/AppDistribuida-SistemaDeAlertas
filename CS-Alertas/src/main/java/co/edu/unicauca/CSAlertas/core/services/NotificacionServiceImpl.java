package co.edu.unicauca.CSAlertas.core.services;

import co.edu.unicauca.CSAlertas.core.cliente.ClienteDeObjetos;
import co.edu.unicauca.CSAlertas.core.models.LecturaDTO;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Service;
import s_gestion_alarmas.sop_corba.AlertaDTO;

/**
 *
 * @author lmarango
 */
@Service
public class NotificacionServiceImpl implements INotificacionService{

    @Override
    public void enviarNotificacion(List<LecturaDTO> prmLstLecturas) {
        s_gestion_alarmas.sop_corba.LecturaDTO[] varLstLecturas = new s_gestion_alarmas.sop_corba.LecturaDTO[prmLstLecturas.size()];
        AlertaDTO varAlerta = new AlertaDTO(varLstLecturas);
        for (int i = 0; i < prmLstLecturas.size(); i++) {
            s_gestion_alarmas.sop_corba.LecturaDTO varLecturaTemp = new s_gestion_alarmas.sop_corba.LecturaDTO();
            varLecturaTemp.nombreZona = prmLstLecturas.get(i).getNombreZona();
            Calendar fecha = prmLstLecturas.get(i).getTiempoCaptura();
            int anio = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minuto = fecha.get(Calendar.MINUTE);
            String tiempoCaptura = dia + "/" + (mes+1) + "/" + anio + " " + (hora-5) + ":" + minuto;
            varLecturaTemp.tiempoCaptura = tiempoCaptura;
            varLecturaTemp.temperatura = prmLstLecturas.get(i).getTemperatura();
            varLecturaTemp.humedad = prmLstLecturas.get(i).getHumedad();
            varLecturaTemp.precipitacion = prmLstLecturas.get(i).getPrecipitacion();
            varLstLecturas[i] = varLecturaTemp;
        }
        varAlerta.listaLecturas = varLstLecturas;
        ClienteDeObjetos.enviarNotificacion(varAlerta);
    }
    
}

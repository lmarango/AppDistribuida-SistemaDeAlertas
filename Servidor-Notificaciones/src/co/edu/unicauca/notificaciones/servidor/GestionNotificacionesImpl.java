package co.edu.unicauca.notificaciones.servidor;

import s_gestrion_notificaciones.sop_corba.AlertaDTO;
import s_gestrion_notificaciones.sop_corba.GestionNotificacionesIntPOA;

/**
 *
 * @author User
 */
public class GestionNotificacionesImpl extends GestionNotificacionesIntPOA{

    public GestionNotificacionesImpl() {
        super();
    }
    
    @Override
    public void enviarNorificacion(AlertaDTO objAlerta) {
        System.out.println("En enviar Notificación()...");
        System.out.println("\n==EXISTE RIESGO DE DESLIZAMIENTO==");
        System.out.println("Zona: " + objAlerta.listaLecturas[0].nombreZona + " de Popayán");
        for (int i = 0; i < objAlerta.listaLecturas.length; i++) {
            System.out.println("Lectura " + (i+1));
            System.out.println("Tiempo: " + objAlerta.listaLecturas[i].tiempoCaptura);
            System.out.println("Temperatura: " + objAlerta.listaLecturas[i].temperatura + " C°");
            System.out.println("Humedad: " + objAlerta.listaLecturas[i].humedad + "%");
            System.out.println("Precipitación: " + objAlerta.listaLecturas[i].precipitacion + " ml");
            System.out.println("");
        }
        System.out.println("\n----------------------------------\n");
    }
}

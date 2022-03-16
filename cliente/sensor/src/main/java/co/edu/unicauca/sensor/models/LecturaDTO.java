package co.edu.unicauca.sensor.models;

import java.util.Calendar;

/**
 *
 * @author User
 */
public class LecturaDTO {
    private String nombreZona;
    private Calendar tiempoCaptura;
    private Integer temperatura;
    private Integer humedad;
    private Integer precipitacion;

    public LecturaDTO(){}

    public LecturaDTO(String nombreZona, Calendar tiempoCaptura, Integer gradosC, Integer humedad, Integer precipitacion) {
        this.setNombreZona(nombreZona);
        this.setTiempoCaptura(tiempoCaptura);
        this.setTemperatura(gradosC);
        this.setHumedad(humedad);
        this.setPrecipitacion(precipitacion);
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public Calendar getTiempoCaptura() {
        return tiempoCaptura;
    }

    public void setTiempoCaptura(Calendar tiempoCaptura) {
        this.tiempoCaptura = tiempoCaptura;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getHumedad() {
        return humedad;
    }

    public void setHumedad(Integer humedad) {
        this.humedad = humedad;
    }

    public Integer getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(Integer precipitacion) {
        this.precipitacion = precipitacion;
    }
}

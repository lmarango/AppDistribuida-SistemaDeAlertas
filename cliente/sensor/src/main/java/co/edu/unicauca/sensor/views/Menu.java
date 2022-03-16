package co.edu.unicauca.sensor.views;

import co.edu.unicauca.sensor.models.LecturaDTO;
import co.edu.unicauca.sensor.services.LecturaServices;
import co.edu.unicauca.sensor.utilities.UtilidadesConsola;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author lmarango
 */
public class Menu {
    private static final LecturaServices objLecServices = new LecturaServices();
    public static void main(String[] args){
        int op;
        do {
            System.out.println("\n**************MENU**************");
            System.out.println("1. Registrar una Lectura*");
            System.out.println("2. Salir");
            System.out.println("*********************************");
            System.out.println("Seleccione una opción: ");
            op = UtilidadesConsola.leerEntero();

            switch (op) {
                case 1 -> registrarLectura();

                case 2 -> System.out.println("Saliendo..."); 

                default -> System.out.println("La opcion ingresada no es válida!");
            }
        } while (op != 2);
    }
    public static void registrarLectura(){
        System.out.println("\n**********Registrar Lectura**********");
        System.out.println("==ZONA==");
        int op = 0;
        do {            
            System.out.println("1. Norte");
            System.out.println("2. Sur");
            System.out.println("3. Oriente");
            System.out.println("4. Occidente");
            System.out.println("-------------");
            System.out.println("Seleccione la zona de popayán donde se hace la lectura: ");
            op = UtilidadesConsola.leerEntero();
        } while (op < 1 || op > 4);
        String varZona="";
        switch (op) {
            case 1 -> varZona = "Norte";
            case 2 -> varZona = "Sur";
            case 3 -> varZona = "Oriente";
            case 4 -> varZona = "Occidente";
        }
        Calendar varFecha = GregorianCalendar.getInstance();
        Integer temperatura = 0;
        Integer varHumedad = 0;
        Integer varPrecipitacion;
        
        System.out.println("==TEMPERATURA (C°)==");
        System.out.println("Ingrese la temperatura: ");
        temperatura = UtilidadesConsola.leerEntero();
        do {            
            System.out.println("==HUMEDAD (%)==");
            System.out.println("Ingrese el porcentaje de humedad: ");
            varHumedad = UtilidadesConsola.leerEntero();
            if(varHumedad < 0 || varHumedad > 100)
                System.out.println("La humedad solo puede tomar valores entre 0 y 100");
        } while (varHumedad < 0 || varHumedad > 100);
        do {            
            System.out.println("==PRECIPITACIÓN (ml)==");
            System.out.println("Ingrese la Precipitación en mililitros (mL): ");
            varPrecipitacion = UtilidadesConsola.leerEntero();
            if (varPrecipitacion <= 0)
                System.out.println("La precipitación debe ser mayor que cero.");
        } while (varPrecipitacion <= 0);
        
        LecturaDTO varLectura = new LecturaDTO(varZona, varFecha, temperatura, varHumedad, varPrecipitacion);
        LecturaDTO varLecturaTmp;
        varLecturaTmp = objLecServices.registrarLectura(varLectura);
        if (varLecturaTmp != null) {
            System.out.println("Lectura registrada exitosamente!");
        }else{
            System.out.println("No se pudo registrar la Lectura!");
        }
    }
}

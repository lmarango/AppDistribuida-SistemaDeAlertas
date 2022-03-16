package co.edu.unicauca.CSAlertas.core.repositories;

import co.edu.unicauca.CSAlertas.core.models.LecturaDTO;
import co.edu.unicauca.CSAlertas.core.services.INotificacionService;
import co.edu.unicauca.CSAlertas.core.services.NotificacionServiceImpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LecturaRepository {
    private ArrayList<LecturaDTO> lstLecturasNorte;
    private ArrayList<LecturaDTO> lstLecturasSur;
    private ArrayList<LecturaDTO> lstLecturasOriente;
    private ArrayList<LecturaDTO> lstLecturasOccidente;
    private INotificacionService notificacionServices;

    public LecturaRepository() {
        lstLecturasNorte = new ArrayList<LecturaDTO>();
        lstLecturasSur = new ArrayList<LecturaDTO>();
        lstLecturasOriente = new ArrayList<LecturaDTO>();
        lstLecturasOccidente = new ArrayList<LecturaDTO>();
        notificacionServices = new NotificacionServiceImpl();
    }

    public List<LecturaDTO> findAll(){
        System.out.println("Invocando a listar Lecturas");
        List<LecturaDTO> objLstLecturas = new ArrayList<LecturaDTO>();
        objLstLecturas.addAll(lstLecturasNorte);
        objLstLecturas.addAll(lstLecturasSur);
        objLstLecturas.addAll(lstLecturasOriente);
        objLstLecturas.addAll(lstLecturasOccidente);
	return objLstLecturas;	
    }

    public List<LecturaDTO> findByZona(String prmZona) {
        System.out.println("Invocando a consultar una Lectura por Zona");
        List<LecturaDTO> objLstLecturas = new ArrayList<LecturaDTO>();
        
        switch (prmZona) {
            case "Norte":
                objLstLecturas = lstLecturasNorte;
                break;
            case "Sur":
                objLstLecturas = lstLecturasSur;
                break;
            case "Oriente":
                objLstLecturas = lstLecturasOriente;
                break;
            case "Occidente":
                objLstLecturas = lstLecturasOccidente;
                break;
        }
        
        return objLstLecturas;
    }

    public LecturaDTO save(LecturaDTO prmLectura) {
        System.out.println("Invocando a almacenar una Lectura.");
        LecturaDTO objLectura = null;
        boolean res = false;
        switch (prmLectura.getNombreZona()) {
            case "Norte":
                if (lstLecturasNorte.add(prmLectura))
                    res = true;
                break;
            case "Sur":
                if (lstLecturasSur.add(prmLectura))
                    res = true;
                break;
            case "Oriente":
                if (lstLecturasOriente.add(prmLectura))
                    res = true;
                break;
            case "Occidente":
                if (lstLecturasOccidente.add(prmLectura))
                    res = true;
                break;
        }
        if (res) {
            objLectura = prmLectura;
            System.out.println("Nueva lectura registrada");
            validarAlerta();
        }
        return objLectura;
    }
    
    private boolean validarLectura(LecturaDTO prmLectura){
        System.out.println("Validando la lectura()");
        boolean res = false;
        if (prmLectura.getTemperatura()< 20 && prmLectura.getHumedad() >= 80 && prmLectura.getPrecipitacion() > 130) {
            res = true;
        }
        return res;
    }
    private void validarAlerta(){
        System.out.println("En validarAlerta()");
        validarAux(lstLecturasNorte);
        validarAux(lstLecturasSur);
        validarAux(lstLecturasOriente);
        validarAux(lstLecturasOccidente);
    }
    private void validarAux(List<LecturaDTO> prmLstLecturas){
        int cont = 0;
        List<LecturaDTO> varListaTemp = new ArrayList<>();
        for (int i = 0; i < prmLstLecturas.size(); i++) {
            if (validarLectura(prmLstLecturas.get(i))) {
                cont = cont + 1;
                varListaTemp.add(prmLstLecturas.get(i));
            }else{
                cont = 0;
                varListaTemp.clear();
            }
            if (cont >= 3) {
                notificacionServices.enviarNotificacion(varListaTemp);
                prmLstLecturas.clear();
            }
        }
    }
}

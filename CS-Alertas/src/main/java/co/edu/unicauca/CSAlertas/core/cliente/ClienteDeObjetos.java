package co.edu.unicauca.CSAlertas.core.cliente;

import co.edu.unicauca.distribuidos.core.utilities.UtilidadesConsola;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import s_gestion_alarmas.sop_corba.AlertaDTO;
import s_gestion_alarmas.sop_corba.GestionNotificacionesIntHelper;
import s_gestion_alarmas.sop_corba.GestionNotificacionesIntOperations;

/**
 *
 * @author User
 */
public class ClienteDeObjetos {
    public static GestionNotificacionesIntOperations ref;
	
	public static void iniciarCliente() {
            try {
                String[] vec = new String[4];
                vec[0] = "-ORBInitialHost";
                //System.out.println("Ingrese la direccion IP donde escucha el n_s");
                vec[1] = "localhost";
                vec[2] = "-ORBInitialPort";
                //System.out.println("Ingrese el puerto donde escucha el n_s");
                vec[3] = "2020";

                // se crea e inicia el ORB
                ORB orb = ORB.init(vec, null);

                // se obtiene un link al name service
                org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
                NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

                // *** Resuelve la referencia del objeto en el N_S ***
                String name = "objRemotoNotificaciones";
                ref = GestionNotificacionesIntHelper.narrow(ncRef.resolve_str(name));
                System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ref);

                }catch(Exception e) {
                    System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
            }
	}
	
    public static void enviarNotificacion(AlertaDTO objAlerta) {
            System.out.println("Notificación enviada...");
            ref.enviarNorificacion(objAlerta);
    }
}

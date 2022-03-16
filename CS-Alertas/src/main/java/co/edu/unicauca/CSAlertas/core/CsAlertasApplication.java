package co.edu.unicauca.CSAlertas.core;

import co.edu.unicauca.CSAlertas.core.cliente.ClienteDeObjetos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsAlertasApplication {

	public static void main(String[] args) {
            SpringApplication.run(CsAlertasApplication.class, args);
            ClienteDeObjetos.iniciarCliente();
	}
}

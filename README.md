# AppDistribuida-SistemaDeAlertas
Aplicación distribuida de un sistema de alertas de deslizamiento para la ciudad de Popayán. 

Cuenta con 3 Roles: un cliente sensor, un Cliente/servidor de Alretas y un servidor de notificaciones.

La comunicación entre el sensor y el servidor de alertas se hace mediante servicios REST utilizando Spring Boot.
La comunicación entre el servidor de alertas y el servidor de notificaciones se hace utilizando el modelo CORBA de la OMG.

## Instrucciones
El orden para lanzar es como sigue:

- Lanzar el ORBD mediante el siguiente comando en el cmd:
    - orbd –ORBInitialHost localhost -ORBInitialPort 2020
- Lanzar el servidor de notificaciones
- Lanzar el servidor de alertas
- Lanzar el sensor

## Sensor
El sistema sensor emula la lectura ingresando los datos por consola. Los datos pedidos son la zona de la lectura (Norte, Sur, Oriente, Occidente), la temperatura en C°, el porcentaje
de humedad (entre 0 y 100) y finalmente la precipitación en mililitros (mL)

## Servidor de Alertas
Recepciona la petición del cliente para registrar una lectura mediante los servicios REST, procesa además cuando una lectura genera es indicadora de un posible alerta, 
si la temperatura es menor a 20C°, la humedad es superior al 80%, y la precipitación es mayor a 130mL se considera a esa lectura como posible alerta. La alerta se genera cuando
en la zona se registran 3 lecturas consecutivas como la antes descrita, al suceder esto se envia una notificacón al servidor de notificaciones.

## Servidor de notificaciones
Recibe una notificación con una alerta de una zona e imprime en consola los datos correspondientes a las lecturas que originaron la alerta de deslizamiento.

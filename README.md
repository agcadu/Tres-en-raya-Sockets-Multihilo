# Juego del Tres en Raya - Aplicación Java Swing Cliente-Servidor

Este repositorio contiene una aplicación del juego del tres en raya con una interfaz gráfica desarrollada en Java Swing. La aplicación consta de un cliente Java Swing que permite jugar contra un servidor multihilo utilizando sockets para la comunicación.

## Requisitos

- JDK 17 o superior instalado en tu sistema.

## Instrucciones
1. **Clona el repositorio**:

```bash
git clone https://github.com/agcadu/Tres-en-raya-Sockets-Multihilo.git
```  
Entra en la carpeta target.

```bash
cd Tres-en-raya-Sockets-Multihilo/target
```

Ejecuta el Cliente y el Servidor:

2.1. **Servidor:**

```bash
java -jar target/TresRayaSockets-0.0.1-SNAPSHOT-server.jar
```
2.2. **Cliente:**

```bash
java -jar target/TresRayaSockets-0.0.1-SNAPSHOT-client.jar
```

Juega al Tres en Raya:

Al ejecutar cliente tendrás la opción de introducir la dirección IP del servidor. Una vez conectado al servidor, podrás jugar al Tres en Raya. El servidor puede aceptar múltiples conexiones de clientes simultáneamente.

### Notas
Asegúrate de tener el JDK adecuado instalado antes de ejecutar la aplicación.
Puedes modificar las configuraciones de los servidores y clientes según tus necesidades en los archivos fuente originales.
Ten en cuenta que esta es una implementación básica del juego del tres en raya y puede requerir mejoras o ajustes. 
### ¡Diviértete jugando al Tres en Raya!

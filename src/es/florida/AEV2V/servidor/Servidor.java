package es.florida.AEV2V.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.err.println("SERVIDOR >>> Arranca el servidor, espera peticion...");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(1234);
		} catch (IOException e) {
			System.err.println("SERVIDOR >>> Error");
			e.printStackTrace();
			return;
		}
		while (true) {		
			Socket conexion;
			try {
				conexion = socketEscucha.accept();
				System.err.println("SERVIDOR >>> Conexion recibida => Se lanza hilo");
				Hilo h = new Hilo(conexion);
				Thread hilo = new Thread(h);
				hilo.start();
			} catch (IOException e) {
				System.err.println("SERVIDOR >>> Error");
				e.printStackTrace();
			}
		}

	}

}

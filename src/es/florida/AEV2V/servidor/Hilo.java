package es.florida.AEV2V.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class Hilo implements Runnable {
	BufferedReader bfr;

	Socket socket;
	String[] tablero = { "_", "_", "_", "_", "_", "_", "_", "_", "_"};
	int tirada =0;
	String ficha = "O";
	

	public Hilo(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Metodo para que el servidor haga la jugada del 3 en raya con un numero random de la posicion que no este ocupada.
	 * @param ficha
	 * @param tablero
	 */
	public static void jugarIA(String ficha, String[]tablero) {
		int posicion;
		boolean posicionOcupada = false;
		int contador=0;
		
		
		do {
			System.out.println("Computadora mueve");			
			posicion = (int)Math.round(Math.random()* 8 +1);
			System.err.println(posicion);
			posicion=posicion-1;
			if(tablero[posicion].equals("_")){
                posicionOcupada = true;
            }else{
                System.out.println("Posicion ocupada");
                posicionOcupada = false;
                contador++;
                if (contador==9) {
					posicionOcupada=true;
				}
            }
		} while (!posicionOcupada);		
		tablero[posicion] = ficha;

	}

	/**
	 *Metodo run en el que realizamos las comunicaciones con el cliente
	 */
	@Override
	public void run() {
		try {
			boolean topeTiradas=true;
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);
			
			do {				
				
					System.err.println("SERVIDOR HILO " + Thread.currentThread().getName() + " >>> Lee tablero de cliente");
					is = socket.getInputStream();
					isr = new InputStreamReader(is);
					bfr = new BufferedReader(isr);
					String pos0 = bfr.readLine();tablero[0]=pos0;
					String pos1 = bfr.readLine();tablero[1]=pos1;
					String pos2 = bfr.readLine();tablero[2]=pos2;
					String pos3 = bfr.readLine();tablero[3]=pos3;
					String pos4 = bfr.readLine();tablero[4]=pos4;
					String pos5 = bfr.readLine();tablero[5]=pos5;
					String pos6 = bfr.readLine();tablero[6]=pos6;
					String pos7 = bfr.readLine();tablero[7]=pos7;
					String pos8 = bfr.readLine();tablero[8]=pos8;															
					System.err.println("SERVIDOR HILO " + Thread.currentThread().getName() + " Realiza la jugada");
					jugarIA(ficha, tablero);
					System.err.println("SERVIDOR HILO " + Thread.currentThread().getName() + " Devuelve resultado a cliente");
					PrintWriter pw = new PrintWriter(socket.getOutputStream());
					pw.print(tablero[0] + "\n");
					pw.print(tablero[1] + "\n");
					pw.print(tablero[2] + "\n");
					pw.print(tablero[3] + "\n");
					pw.print(tablero[4] + "\n");
					pw.print(tablero[5] + "\n");
					pw.print(tablero[6] + "\n");
					pw.print(tablero[7] + "\n");
					pw.print(tablero[8] + "\n");
					pw.flush();	
							
					int tableroLleno=0;
					for (int i = 0; i < tablero.length; i++) {
						if (tablero[i].equals("_")) {
							tableroLleno++;
						}
					}

					if (tableroLleno==0) {
						topeTiradas=false;	

					}			
				tirada++;						
			} while (topeTiradas);
				
			
		} catch (IOException e) {			
			System.err.println("SERVIDOR HILO " + Thread.currentThread().getName() + " >>> Se cierra hilo.");
		}

	}

}
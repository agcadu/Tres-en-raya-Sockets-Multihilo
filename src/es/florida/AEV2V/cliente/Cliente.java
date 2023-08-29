package es.florida.AEV2V.cliente;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 150843830830036396L;
	private JPanel contentPane;
	private static JTextField textFieldIP;
	private JLabel lblNewLabel;
	private JButton btnConectar;
	private static JButton btn0;
	private static JButton btn1;
	private static JButton btn2;
	private static JButton btn3;
	private static JButton btn4;
	private static JButton btn5;
	private static JButton btn6;
	private static JButton btn7;
	private static JButton btn8;
	static BufferedReader bfr;
	static PrintWriter pw;
	static Socket socket;
	public String[] tablero = { "_", "_", "_", "_", "_", "_", "_", "_", "_" };
	static int tirada = 0;
	static boolean ganador = false;
	public static String ficha = tirada%2==0? "X":"O";
	static int posicion;
	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cliente() {
		setTitle("TRES EN RAYA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldIP = new JTextField();
		textFieldIP.setBounds(102, 11, 194, 20);
		contentPane.add(textFieldIP);
		textFieldIP.setColumns(10);

		lblNewLabel = new JLabel("HOST");
		lblNewLabel.setBounds(21, 14, 39, 14);
		contentPane.add(lblNewLabel);

		btnConectar = new JButton("CONECTAR");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectar(tablero);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "ERROR DE CONEXION ");
				}
			}
		});
		btnConectar.setBounds(339, 10, 108, 23);
		contentPane.add(btnConectar);

		btn0 = new JButton(tablero[0]);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					posicion = 0;
					jugar(ficha, tablero, posicion);
																				
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btn0.setBounds(10, 63, 131, 115);
		contentPane.add(btn0);

		btn1 = new JButton(tablero[1]);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					posicion = 1;
					jugar(ficha, tablero, posicion);
										
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn1.setBounds(165, 63, 131, 115);
		contentPane.add(btn1);

		btn2 = new JButton(tablero[2]);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					posicion = 2;
					jugar(ficha, tablero, posicion);
										
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn2.setBounds(316, 63, 131, 115);
		contentPane.add(btn2);

		btn3 = new JButton(tablero[3]);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					posicion = 3;
					jugar(ficha, tablero, posicion);
										
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn3.setBounds(10, 193, 131, 115);
		contentPane.add(btn3);

		btn4 = new JButton(tablero[4]);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					posicion = 4;
					jugar(ficha, tablero, posicion);
										
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn4.setBounds(161, 193, 131, 115);
		contentPane.add(btn4);

		btn5 = new JButton(tablero[5]);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					posicion = 5;
					jugar(ficha, tablero, posicion);
										
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn5.setBounds(316, 193, 131, 115);
		contentPane.add(btn5);

		btn6 = new JButton(tablero[6]);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					posicion = 6;
					jugar(ficha, tablero, posicion);
										
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn6.setBounds(10, 319, 131, 115);
		contentPane.add(btn6);

		btn7 = new JButton(tablero[7]);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					posicion = 7;
					jugar(ficha, tablero, posicion);
										
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn7.setBounds(161, 319, 131, 115);
		contentPane.add(btn7);

		btn8 = new JButton(tablero[8]);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					posicion = 8;
					jugar(ficha, tablero, posicion);
										
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn8.setBounds(316, 319, 131, 115);
		contentPane.add(btn8);

	}

	/**
	 * Metodo Getter para acceder al JTextFieldIP
	 * @return
	 */
	public static JTextField getTextFieldIP() {
		return textFieldIP;
	}


	public JButton getBtn0() {
		return btn0;
	}

	/**
	 * Metodo que conecta el cliente con el servidor por la IP especificada y ademas genera una array vacia de 9 posiciones que simula un tablero del juego 3 en raya.
	 * @param tablero
	 * @throws IOException	 * 
	 */
	public static void conectar(String[] tablero) throws IOException {
		System.out.println("CLIENTE >>> Arranca cliente");
		System.out.println("CLIENTE >>> Conexion al servidor");
		String host = getTextFieldIP().getText();
		InetSocketAddress direccion = new InetSocketAddress(host, 1234);
		socket = new Socket();
		socket.connect(direccion);
		for (int i = 0; i < tablero.length; i++) {
			tablero[i]="_";
		}
		iniciarTablero(tablero);

	}
	/**
	 * Metodo para realizar el la jugada por parte del cliente y enviar al servidor la situacion del tablero
	 * @param ficha
	 * @param tablero
	 * @param posicion
	 * @throws IOException
	 */
	public static void jugar(String ficha, String[] tablero, int posicion) throws IOException {

		
		boolean posicionOcupada = false;
		
		do {		
			
			if(tablero[posicion].equals("_")){
				tablero[posicion] = ficha;
				tiradaBtn(posicion, tablero);
				iniciarTablero(tablero);
                posicionOcupada = true;
            }else{
                System.out.println("Posicion ocupada");                
                posicionOcupada = true;
                                            }
		} while (!posicionOcupada);		
		

	}

	/**
	 * Metodo para la comunicacion entre cliente/servidor del tablero del 3 en raya cada vez que se pulsa un boton.
	 * @param posicion
	 * @param tablero
	 * @throws IOException
	 */
	public static void tiradaBtn(int posicion, String[] tablero) throws IOException {
		
		
		System.out.println("CLIENTE >>> Envio de tablero al servidor ");
		pw = new PrintWriter(socket.getOutputStream());
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
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		bfr = new BufferedReader(isr);
		System.out.println("CLIENTE  >>> Recibe datos del servidor");
		String pos0 = bfr.readLine();
		tablero[0] = pos0;
		String pos1 = bfr.readLine();
		tablero[1] = pos1;
		String pos2 = bfr.readLine();
		tablero[2] = pos2;
		String pos3 = bfr.readLine();
		tablero[3] = pos3;
		String pos4 = bfr.readLine();
		tablero[4] = pos4;
		String pos5 = bfr.readLine();
		tablero[5] = pos5;
		String pos6 = bfr.readLine();
		tablero[6] = pos6;
		String pos7 = bfr.readLine();
		tablero[7] = pos7;
		String pos8 = bfr.readLine();
		tablero[8] = pos8;
		iniciarTablero(tablero);
		

		ganador = evaluarGanador(tablero);
		if (ganador) {			
			JOptionPane.showMessageDialog(null, "SE ACABO EL JUEGO!!!!!\n PULSA CONECTAR PARA EMPEZAR UNO NUEVO");		

		}
		int tableroLleno=0;
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i].equals("_")) {
				tableroLleno++;
			}
		}

		if (tableroLleno==0) {
			JOptionPane.showMessageDialog(null, "PULSA CONECTAR PARA EMPEZAR UNO NUEVO");

		}
		tirada++;

	}


	/**
	 * Metodo para evaluar tadas las posibilidades para ganar el juego del 3 en raya
	 * @param tablero
	 * @return booleano true si se gana el juego y false si no se gana el juego
	 */
	public static boolean evaluarGanador(String tablero[]) {
		if (tablero[0].equals(tablero[1]) && tablero[0].equals(tablero[2]) && !tablero[0].equals("_")) {
			return true;
		} else if (tablero[3].equals(tablero[4]) && tablero[3].equals(tablero[5]) && !tablero[3].equals("_")) {
			return true;
		} else if (tablero[6].equals(tablero[7]) && tablero[6].equals(tablero[8]) && !tablero[6].equals("_")) {
			return true;
		} else if (tablero[0].equals(tablero[3]) && tablero[0].equals(tablero[6]) && !tablero[0].equals("_")) {
			return true;
		} else if (tablero[1].equals(tablero[4]) && tablero[1].equals(tablero[7]) && !tablero[1].equals("_")) {
			return true;
		} else if (tablero[2].equals(tablero[5]) && tablero[2].equals(tablero[8]) && !tablero[2].equals("_")) {
			return true;
		} else if (tablero[0].equals(tablero[4]) && tablero[0].equals(tablero[8]) && !tablero[0].equals("_")) {
			return true;
		} else if (tablero[2].equals(tablero[4]) && tablero[2].equals(tablero[6]) && !tablero[2].equals("_")) {
			return true;
		}

		return false;
	}

	/**
	 * Metodo para imprimir por pantalla la situacion del tablero del 3 en raya
	 * @param tablero
	 */
	public static void iniciarTablero(String[] tablero) {
		btn0.setText(tablero[0]);btn1.setText(tablero[1]);btn2.setText(tablero[2]);
		btn3.setText(tablero[3]);btn4.setText(tablero[4]);btn5.setText(tablero[5]);
		btn6.setText(tablero[6]);btn7.setText(tablero[7]);btn8.setText(tablero[8]);
	}
}

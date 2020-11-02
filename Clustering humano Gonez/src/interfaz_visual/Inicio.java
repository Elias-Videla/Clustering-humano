package interfaz_visual;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.SystemColor;

public class Inicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(221, 220, 197));
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCargarPersonasManualmente = new JButton("Cargar personas manualmente");
		btnCargarPersonasManualmente.setBounds(108, 363, 206, 23);
		frame.getContentPane().add(btnCargarPersonasManualmente);
		
		JButton btnCargarPersonasAutomticamente = new JButton("Cargar personas autom\u00E1ticamente");
		btnCargarPersonasAutomticamente.setBounds(108, 413, 206, 23);
		frame.getContentPane().add(btnCargarPersonasAutomticamente);
	}
}

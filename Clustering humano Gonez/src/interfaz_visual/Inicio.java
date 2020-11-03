package interfaz_visual;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseMotionAdapter;

public class Inicio {

	private JFrame frame;
	
	private JLabel botonSalir;
	private JLabel imagoTipo;

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
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		
		
		JButton btnCargarPersonasManualmente = new JButton("");
		movimientoCursor(btnCargarPersonasManualmente);
		btnCargarPersonasManualmente.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/MANUAL.png")));
		btnCargarPersonasManualmente.setFocusPainted( false );
		btnCargarPersonasManualmente.setBorderPainted( false );
		btnCargarPersonasManualmente.setBackground(new Color(149, 137, 118));
		btnCargarPersonasManualmente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Carga_manual c = new Carga_manual();
				c.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCargarPersonasManualmente.setBounds(118, 351, 211, 65);
		frame.getContentPane().add(btnCargarPersonasManualmente);
		
		
		
		JButton btnCargarPersonasAutomticamente = new JButton("");
		movimientoCursor(btnCargarPersonasAutomticamente);
		btnCargarPersonasAutomticamente.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/AUTOMATICA.png")));
		btnCargarPersonasAutomticamente.setFocusPainted( false );
		btnCargarPersonasAutomticamente.setBorderPainted( false );
		btnCargarPersonasAutomticamente.setBackground(new Color(149, 137, 118));
		btnCargarPersonasAutomticamente.setBounds(118, 438, 211, 65);
		frame.getContentPane().add(btnCargarPersonasAutomticamente);
		
		
		
		
		botonSalir = new JLabel("");
		botonSalir.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked( MouseEvent arg0 ) 
			{
				System.exit( 0 );
			}
		});
		botonSalir.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/boton-salir.png")));
		botonSalir.setBounds(416, 11, 24, 29);
		frame.getContentPane().add(botonSalir);
		
		
		
		imagoTipo = new JLabel("");
		imagoTipo.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/imago-tipo.png")));
		imagoTipo.setBounds(108, 116, 206, 205);
		frame.getContentPane().add(imagoTipo);
		
	}
	
	private void movimientoCursor(JButton boton) 
	{
		boton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) 
			{
				boton.setBackground( new Color( 151, 142, 137 ) );

			}
		});
		boton.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseExited( MouseEvent arg0 ) 
			{
				boton.setBackground( new Color( 149, 137, 118 ) );
			}
		} );
	}
}

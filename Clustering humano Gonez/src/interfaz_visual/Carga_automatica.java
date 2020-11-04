package interfaz_visual;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import clustering.Persona;
import clustering.Principal;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import javax.swing.JRadioButton;

public class Carga_automatica {

	public JFrame frame;
	private JTextArea textArea;
	private JLabel botonSalir;
	private JLabel botonVolver;
	private ButtonGroup botonGroup;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Carga_manual window = new Carga_manual();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Carga_automatica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Principal p = new Principal();
		botonGroup = new ButtonGroup();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(221, 220, 197));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(429, 99, 330, 396);
		textArea.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		textArea.setMargin(new Insets(12, 7, 12, 12));
		textArea.append("Nombre    " + "| D | M | E | C \n");
		
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 99, 290, 362);
		panel.setBackground(new Color(149, 137, 118));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		
		JLabel lblInteresDeporte = new JLabel("Interes deporte:");
		lblInteresDeporte.setForeground(new Color(221, 220, 197));
		lblInteresDeporte.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblInteresDeporte.setBounds(22, 116, 198, 20);
		panel.add(lblInteresDeporte);
		
		JLabel lblInteresMusica = new JLabel("Interes musica:");
		lblInteresMusica.setForeground(new Color(221, 220, 197));
		lblInteresMusica.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblInteresMusica.setBounds(22, 156, 198, 20);
		panel.add(lblInteresMusica);
		
		JLabel lblInteresEspectaculo = new JLabel("Interes espectaculo:");
		lblInteresEspectaculo.setForeground(new Color(221, 220, 197));
		lblInteresEspectaculo.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblInteresEspectaculo.setBounds(22, 196, 198, 20);
		panel.add(lblInteresEspectaculo);
		
		
		JLabel lblInteresCiencia = new JLabel("Interes ciencia:");
		lblInteresCiencia.setForeground(new Color(221, 220, 197));
		lblInteresCiencia.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblInteresCiencia.setBounds(22, 236, 198, 20);
		panel.add(lblInteresCiencia);
		
		
		
		
		
		JRadioButton boton5personas = new JRadioButton("");
		boton5personas.setBackground(new Color(149, 137, 118));
		boton5personas.setBounds(226, 117, 109, 23);
		panel.add(boton5personas);
		botonGroup.add(boton5personas);
		
		JRadioButton boton10personas = new JRadioButton("");
		boton10personas.setBackground(new Color(149, 137, 118));
		boton10personas.setBounds(226, 157, 109, 23);
		panel.add(boton10personas);
		botonGroup.add(boton10personas);
		
		JRadioButton boton15personas = new JRadioButton("");
		boton15personas.setBackground(new Color(149, 137, 118));
		boton15personas.setBounds(226, 197, 109, 23);
		panel.add(boton15personas);
		botonGroup.add(boton15personas);
		
		JRadioButton boton20personas = new JRadioButton("");
		boton20personas.setBackground(new Color(149, 137, 118));
		boton20personas.setBounds(226, 237, 109, 23);
		panel.add(boton20personas);
		botonGroup.add(boton20personas);
		
		JButton btnAgregarPersona = new JButton("");
		btnAgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if(boton5personas.isSelected()) 
				{
					imprimirListaPersonas(ManejoArchivo.lista_A());
				}
			}
		});
		btnAgregarPersona.setIcon(new ImageIcon(Carga_manual.class.getResource("/imagenes/AGREGAR.png")));
		btnAgregarPersona.setFocusPainted( false );
		btnAgregarPersona.setBorderPainted( false );
		btnAgregarPersona.setBackground(new Color(221, 220, 197));
	
		btnAgregarPersona.setBounds(78, 288, 129, 36);
		panel.add(btnAgregarPersona);
		
		JButton btnCrearGrupos = new JButton("Crear grupos");
		btnCrearGrupos.setBounds(128, 472, 119, 23);
		btnCrearGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(p.tamanoListaPersona() >= 2) {
					ArrayList<String> listaA = p.creaGrafo().get(0);
					ArrayList<String> listaB = p.creaGrafo().get(1);

					imprimirGrupos(listaA, listaB);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Minimo 2 personas para agrupar");
				}
			}
		});
		frame.getContentPane().add(btnCrearGrupos);
		
		botonSalir = new JLabel("");
		botonSalir.setBounds(766, 11, 24, 31);
		botonSalir.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked( MouseEvent arg0 ) 
			{
				System.exit( 0 );
			}
		});
		botonSalir.setIcon(new ImageIcon(Carga_manual.class.getResource("/imagenes/boton-salir.png")));
		frame.getContentPane().add(botonSalir);
		
		JLabel isotipo = new JLabel("");
		isotipo.setBounds(10, 11, 50, 49);
		isotipo.setIcon(new ImageIcon(Carga_manual.class.getResource("/imagenes/isotipo.png")));
		frame.getContentPane().add(isotipo);
		
		botonVolver = new JLabel("");
		botonVolver.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked( MouseEvent arg0 ) 
			{
				Inicio inicio = new Inicio();
				inicio.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		botonVolver.setIcon(new ImageIcon(Carga_manual.class.getResource("/imagenes/boton-volver.png")));
		botonVolver.setBounds(709, 11, 43, 31);
		frame.getContentPane().add(botonVolver);
		
		
		
	}
	
	private void imprimirGrupos(ArrayList<String> listaA, ArrayList<String> listaB) 
	{
		textArea.setText(null);
		textArea.append("--------Grupo 1-------- \n");
		for(int i = 0; i < listaA.size()/2; i++) 
		{
			textArea.append(listaA.get(i) + " ");
		}
		
		textArea.append("\n--------Grupo 2--------\n");
		for(int i = 0; i < listaB.size()/2; i++) 
		{
			textArea.append(listaB.get(i) + " ");
		}
	}
	
	@SuppressWarnings("unused")
	private void imprimirListaPersonas(ArrayList<Persona> lista) 
	{
		for(int i = 0; i < lista.size(); i++) 
		{
			textArea.append(lista.get(i).nombre() + " " + lista.get(i).interesDeporte() + " " + 
					lista.get(i).interesMusica() + " " + lista.get(i).interesEspectaculo() + " " +
					lista.get(i).interesCiencia() + "\n");
		}
	}
}

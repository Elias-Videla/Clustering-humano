package interfaz_visual;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import clustering.Persona;
import clustering.Principal;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class Carga_automatica {

	private JFrame frame;
	private JTextArea textArea;
	private JLabel botonSalir;
	private JLabel botonVolver;
	private ButtonGroup botonGroup;
	private Principal principal;


	/**
	 * Create the application.
	 */
	public Carga_automatica() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		principal = new Principal();
		
		botonGroup = new ButtonGroup();
		
		frame = new JFrame();
		frame.getContentPane().setBackground( new Color( 221, 220, 197 ) );
		frame.setBounds( 100, 100, 800, 600 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setUndecorated( true );
		frame.setLocationRelativeTo( null );
		frame.getContentPane().setLayout( null );
		
		
		
		
		textArea = new JTextArea();
		textArea.setBounds( 429, 99, 330, 396 );
		textArea.setFont( new Font( "Arial Black", Font.PLAIN, 12 ) );
		textArea.setComponentOrientation( ComponentOrientation.LEFT_TO_RIGHT );
		textArea.setWrapStyleWord( true );
		textArea.setEditable( false );
		frame.getContentPane().add( textArea );
		textArea.setMargin( new Insets( 5, 5, 12, 12 ) );
		textArea.append( "Nombre " + "| Deporte | Musica | Espectaculo | Ciencia\n" );
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds( 53, 99, 290, 362 );
		panel.setBackground( new Color( 149, 137, 118 ) );
		frame.getContentPane().add( panel );
		panel.setLayout( null );
		
		
		
		
		JLabel lblSugerenciaVolver = new JLabel( "Volver" );
		lblSugerenciaVolver.setFont( new Font( "Tahoma", Font.PLAIN, 13 ) );
		lblSugerenciaVolver.setBounds( 662, 11, 43, 31 );
		frame.getContentPane().add( lblSugerenciaVolver );
		lblSugerenciaVolver.setVisible( false );
		
		
		
		
		JLabel lblAlumnos = new JLabel( "Alumnos (7)" );
		lblAlumnos.setForeground( new Color( 221, 220, 197 ) );
		lblAlumnos.setFont( new Font( "Arial Black", Font.PLAIN, 15 ) );
		lblAlumnos.setBounds( 22, 116, 198, 20 );
		panel.add( lblAlumnos );
		
		
		
		JLabel lblProfesores = new JLabel( "Profesores (18)" );
		lblProfesores.setForeground( new Color( 221, 220, 197 ) );
		lblProfesores.setFont( new Font( "Arial Black", Font.PLAIN, 15 ) );
		lblProfesores.setBounds( 22, 156, 198, 20 );
		panel.add( lblProfesores );
		
		
		
		JLabel lblPersonajesTV = new JLabel( "Personajes tv (7)" );
		lblPersonajesTV.setForeground( new Color( 221, 220, 197 ) );
		lblPersonajesTV.setFont( new Font( "Arial Black", Font.PLAIN, 15 ) );
		lblPersonajesTV.setBounds( 22, 196, 198, 20 );
		panel.add( lblPersonajesTV );
		
		
		
		JLabel lblDeportistas = new JLabel( "Deportistas (9)" );
		lblDeportistas.setForeground( new Color( 221, 220, 197 ) );
		lblDeportistas.setFont( new Font( "Arial Black", Font.PLAIN, 15 ) );
		lblDeportistas.setBounds( 22, 236, 198, 20 );
		panel.add( lblDeportistas );
		
		
		
		
		JLabel lblListaDePersonas = new JLabel( "Lista de personas" );
		lblListaDePersonas.setForeground( new Color( 221, 220, 197 ) );
		lblListaDePersonas.setFont( new Font( "Arial Black", Font.PLAIN, 15 ) );
		lblListaDePersonas.setBounds( 61, 69, 198, 20 );
		panel.add( lblListaDePersonas );
		
		
		
		
		JRadioButton radioAlumnos = new JRadioButton( "" );
		radioAlumnos.setBackground( new Color( 149, 137, 118 ) );
		radioAlumnos.setBounds( 226, 117, 109, 23 );
		panel.add( radioAlumnos );
		radioAlumnos.setSelected( true );
		botonGroup.add( radioAlumnos );
		
		
		
		JRadioButton radioProfesores = new JRadioButton( "" );
		radioProfesores.setBackground( new Color( 149, 137, 118 ) );
		radioProfesores.setBounds( 226, 157, 109, 23 );
		panel.add( radioProfesores );
		botonGroup.add( radioProfesores );
		
		
		
		JRadioButton radioPersonajesTV = new JRadioButton( "" );
		radioPersonajesTV.setBackground( new Color( 149, 137, 118 ) );
		radioPersonajesTV.setBounds( 226, 197, 109, 23 );
		panel.add( radioPersonajesTV );
		botonGroup.add( radioPersonajesTV );
		
		
		
		JRadioButton radioDeportistas = new JRadioButton( "" );
		radioDeportistas.setBackground( new Color( 149, 137, 118 ) );
		radioDeportistas.setBounds( 226, 237, 109, 23 );
		panel.add( radioDeportistas );
		botonGroup.add( radioDeportistas );
		
		
		
		
		JButton btnVerPersonas = new JButton( "" );
		movimientoBotonVer(btnVerPersonas);
		btnVerPersonas.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent arg0 )
			{
				if( radioAlumnos.isSelected() ) 
				{
					imprimirListaPersonas( ManejoArchivo.lista_A() );
				}
				if( radioProfesores.isSelected() ) 
				{
					imprimirListaPersonas( ManejoArchivo.lista_B() );
				}
				if( radioPersonajesTV.isSelected() ) 
				{
					imprimirListaPersonas( ManejoArchivo.lista_C() );
				}
				if( radioDeportistas.isSelected() ) 
				{
					imprimirListaPersonas( ManejoArchivo.lista_D() );
				}
				
			}
		} );
		btnVerPersonas.setIcon( new ImageIcon(Carga_automatica.class.getResource("/imagenes/ver.png")) );
		btnVerPersonas.setFocusPainted( false );
		btnVerPersonas.setBorderPainted( false );
		btnVerPersonas.setBackground( new Color( 221, 220, 197 ) );
		btnVerPersonas.setBounds( 78, 288, 129, 36 );
		panel.add( btnVerPersonas );
		
	
		
		
		JButton btnCrearGrupos = new JButton( "" );
		movimientoBotonCrear(btnCrearGrupos);
		btnCrearGrupos.setIcon(new ImageIcon(Carga_automatica.class.getResource("/imagenes/CREAR-GRUPOS.png")));
		btnCrearGrupos.setFocusPainted( false );
		btnCrearGrupos.setBorderPainted( false );
		btnCrearGrupos.setBackground( new Color( 29, 35, 38 ) );
		btnCrearGrupos.setBounds( 115, 513, 184, 34 );
		btnCrearGrupos.addActionListener(new ActionListener() 
		{
			public void actionPerformed( ActionEvent arg0 ) 
			{
				if( radioAlumnos.isSelected() )
				{
					agregarPersonasAlGrupo( ManejoArchivo.lista_A() );
				}
				if( radioProfesores.isSelected() )
				{	
					agregarPersonasAlGrupo( ManejoArchivo.lista_B() );
				}
				if( radioPersonajesTV.isSelected() )
				{	
					agregarPersonasAlGrupo( ManejoArchivo.lista_C() );
				}
				if( radioDeportistas.isSelected() )
				{	
					agregarPersonasAlGrupo( ManejoArchivo.lista_D() );
				}

				ArrayList< String > listaA = principal.crearGrupos().get( 0 );
				ArrayList< String > listaB = principal.crearGrupos().get( 1 );

				imprimirGrupos( listaA, listaB );
				
				btnCrearGrupos.setEnabled( false );
				btnVerPersonas.setEnabled( false );
				lblSugerenciaVolver.setVisible( true );
			}
		} );
		frame.getContentPane().add( btnCrearGrupos );
		
		
		
		
		botonSalir = new JLabel( "" );
		botonSalir.setBounds( 766, 11, 24, 31 );
		botonSalir.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked( MouseEvent arg0 ) 
			{
				System.exit( 0 );
			}
		} );
		botonSalir.setIcon( new ImageIcon( Carga_manual.class.getResource( "/imagenes/boton-salir.png" ) ) );
		frame.getContentPane().add( botonSalir );
		
		
		
		
		JLabel lblHechoPor = new JLabel("Hecho por Elias Go\u00F1ez");
		lblHechoPor.setForeground( new Color( 29, 35, 38 ) );
		lblHechoPor.setBounds(57, 28, 131, 14);
		frame.getContentPane().add(lblHechoPor);
		lblHechoPor.setVisible(false);
		
		
		
		
		JLabel isotipo = new JLabel( "" );
		isotipo.addMouseListener( new MouseAdapter() 
		{
			@Override
			public void mouseEntered( MouseEvent arg0 ) 
			{
				lblHechoPor.setVisible( true );
			}
			@Override
			public void mouseExited( MouseEvent e ) 
			{
				lblHechoPor.setVisible( false );
			}
		} );
		isotipo.setBounds( 10, 11, 50, 49 );
		isotipo.setIcon( new ImageIcon( Carga_manual.class.getResource( "/imagenes/isotipo.png") ) );
		frame.getContentPane().add( isotipo );
		
		
		
		
		botonVolver = new JLabel( "" );
		botonVolver.addMouseListener( new MouseAdapter() 
		{
			@Override
			public void mouseClicked( MouseEvent arg0 ) 
			{
				Inicio inicio = new Inicio();
				inicio.getFrame().setVisible(true);
				frame.setVisible( false );
			}
		} );
		botonVolver.setIcon( new ImageIcon( Carga_manual.class.getResource( "/imagenes/boton-volver.png" ) ) );
		botonVolver.setBounds( 709, 11, 43, 31 );
		frame.getContentPane().add( botonVolver );
		
	}
	
	
	
	
	public JFrame getFrame() 
	{
		return frame;
	}
	
	
	//Metodos privados-----------------------------------------------------------------------------------------
	
	private void imprimirGrupos( ArrayList< String > listaA, ArrayList< String > listaB ) 
	{
		textArea.setText( null );
		textArea.append( "--------Grupo 1-------- \n" );
		for( int i = 0; i < listaA.size()/2; i++ ) 
		{
			textArea.append( listaA.get( i ) + " \n" );
		}
		
		textArea.append( "\n--------Grupo 2--------\n" );
		for( int i = 0; i < listaB.size()/2; i++ ) 
		{
			textArea.append( listaB.get( i ) + " \n" );
		}
	}
	
	
	
	@SuppressWarnings("unused")
	private void imprimirListaPersonas( ArrayList<Persona> lista ) 
	{
		textArea.setText( null );
		textArea.append( "Nombre " + "| Deporte | Musica | Espectaculo | Ciencia\n" );
		for( int i = 0; i < lista.size(); i++ ) 
		{
			textArea.append( lista.get( i ).nombre() + "    " + lista.get( i ).interesDeporte() + " " + 
					lista.get( i ).interesMusica() + " " + lista.get( i ).interesEspectaculo() + " " +
					lista.get( i ).interesCiencia() + "\n" );
		}
	}
	
	
	
	@SuppressWarnings("unused")
	private void agregarPersonasAlGrupo( ArrayList< Persona > lista ) 
	{
		for(int i = 0; i < lista.size(); i++) 
		{
			String nombre     = lista.get( i ).nombre();
			int i_deporte     = lista.get( i ).interesDeporte();
			int i_musica      = lista.get( i ).interesMusica();
			int i_espectaculo = lista.get( i ).interesEspectaculo();
			int i_ciencia     = lista.get( i ).interesCiencia();
			
			principal.agregarPersona( nombre, i_deporte, i_musica, i_espectaculo, i_ciencia );
		}
	}
	
	
	
	private void movimientoBotonCrear( JButton boton ) 
	{
		boton.addMouseMotionListener( new MouseMotionAdapter()
		{
			@Override
			public void mouseMoved( MouseEvent arg0 ) 
			{
				boton.setBackground( new Color( 151, 142, 137 ) );

			}
		} );
		boton.addMouseListener( new MouseAdapter() 
		{
			@Override
			public void mouseExited( MouseEvent arg0 ) 
			{
				boton.setBackground( new Color( 149, 137, 118 ) );
			}
		} );
	}
	
	
	
	
	private void movimientoBotonVer( JButton boton ) 
	{
		boton.addMouseMotionListener( new MouseMotionAdapter() 
		{
			@Override
			public void mouseMoved( MouseEvent arg0 ) 
			{
				boton.setBackground( new Color( 199, 198, 177 ) );

			}
		} );
		boton.addMouseListener( new MouseAdapter()
		{
			@Override
			public void mouseExited( MouseEvent arg0 ) 
			{
				boton.setBackground( new Color( 221, 220, 197 ) );
			}
		} );
	}
}

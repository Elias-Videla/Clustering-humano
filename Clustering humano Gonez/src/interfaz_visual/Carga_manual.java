package interfaz_visual;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clustering.Principal;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;

public class Carga_manual {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextArea textArea;
	private JLabel botonSalir;
	private JLabel botonVolver;


	/**
	 * Create the application.
	 */
	public Carga_manual()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		Principal principal = new Principal();
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground( new Color( 221, 220, 197 ) );
		frame.setBounds( 100, 100, 800, 600 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setUndecorated( true );
		frame.setLocationRelativeTo( null );
		frame.getContentPane().setLayout( null );
		
	
		
		
		textArea = new JTextArea();
		textArea.setBounds( 429, 99, 330, 396 );
		textArea.setFont ( new Font( "Arial Black", Font.PLAIN, 12 ) );
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
		
		
		
		
		JLabel lblNombre = new JLabel( "Nombre:" );
		lblNombre.setForeground( new Color( 221, 220, 197 ) );
		lblNombre.setFont( new Font( "Arial Black", Font.PLAIN, 15 ) );
		lblNombre.setBounds( 23, 76, 96, 14 );
		panel.add( lblNombre );
		
		
		
		
		textFieldNombre = new JTextField();
		textFieldNombre.setMargin( new Insets( 0, 2, 2, 2 ) );
		textFieldNombre.setBackground( new Color( 221, 220, 197 ) );
		textFieldNombre.addKeyListener( new KeyAdapter() 
		{
			@Override
			public void keyTyped( KeyEvent arg0 ) 
			{
				if ( textFieldNombre.getText().length() == 12 ) 
			         arg0.consume(); 
			}
		} );
		textFieldNombre.setFont( new Font( "Arial Black", Font.PLAIN, 13 ) );
		textFieldNombre.setBounds( 129, 73, 136, 23 );
		panel.add( textFieldNombre );
		textFieldNombre.setColumns( 10 );
		
		
		
		
		JLabel lblInteresDeporte = new JLabel( "Interes deporte:" );
		lblInteresDeporte.setForeground( new Color( 221, 220, 197 ) );
		lblInteresDeporte.setFont( new Font( "Arial Black", Font.PLAIN, 15 ) );
		lblInteresDeporte.setBounds( 22, 116, 198, 20 );
		panel.add( lblInteresDeporte );
		
		
		
		JLabel lblInteresMusica = new JLabel( "Interes musica:" );
		lblInteresMusica.setForeground( new Color( 221, 220, 197 ) );
		lblInteresMusica.setFont( new Font( "Arial Black", Font.PLAIN, 15 ) );
		lblInteresMusica.setBounds( 22, 156, 198, 20 );
		panel.add( lblInteresMusica );
		
		
		
		JLabel lblInteresEspectaculo = new JLabel( "Interes espectaculo:" );
		lblInteresEspectaculo.setForeground( new Color( 221, 220, 197 ) );
		lblInteresEspectaculo.setFont( new Font( "Arial Black", Font.PLAIN, 15 ) );
		lblInteresEspectaculo.setBounds( 22, 196, 198, 20 );
		panel.add( lblInteresEspectaculo );
		
		
		
		JLabel lblInteresCiencia = new JLabel( "Interes ciencia:" );
		lblInteresCiencia.setForeground( new Color( 221, 220, 197 ) );
		lblInteresCiencia.setFont( new Font( "Arial Black", Font.PLAIN, 15 ) );
		lblInteresCiencia.setBounds( 22, 236, 198, 20 );
		panel.add( lblInteresCiencia );
		
		
		
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_i_deporte = new JComboBox();
		comboBox_i_deporte.setBackground( new Color( 221, 220, 197 ) );
		comboBox_i_deporte.setBounds( 228, 116, 37, 20 );
		panel.add( comboBox_i_deporte );
		crearComboBox( comboBox_i_deporte );

		
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_i_musica = new JComboBox();
		comboBox_i_musica.setBackground( new Color( 221, 220, 197 ) );
		comboBox_i_musica.setBounds( 228, 156, 37, 20 );
		panel.add( comboBox_i_musica );
		crearComboBox( comboBox_i_musica );

		
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_i_espectaculo = new JComboBox();
		comboBox_i_espectaculo.setBackground( new Color( 221, 220, 197 ) );
		comboBox_i_espectaculo.setBounds( 228, 196, 37, 20 );
		panel.add( comboBox_i_espectaculo );
		crearComboBox( comboBox_i_espectaculo );

		
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_i_ciencia = new JComboBox();
		comboBox_i_ciencia.setBackground( new Color( 221, 220, 197 ) );
		comboBox_i_ciencia.setBounds( 228, 236, 37, 20 );
		panel.add( comboBox_i_ciencia );
		crearComboBox( comboBox_i_ciencia );
		
		
		
		
		JButton btnAgregarPersona = new JButton( "" );
		movimientoBotonAgregar( btnAgregarPersona );
		btnAgregarPersona.setIcon (new ImageIcon( Carga_manual.class.getResource( "/imagenes/AGREGAR.png" ) ) );
		btnAgregarPersona.setFocusPainted( false );
		btnAgregarPersona.setBorderPainted( false );
		btnAgregarPersona.setBackground( new Color( 221, 220, 197 ) );
		btnAgregarPersona.addActionListener( new ActionListener() 
		{
			public void actionPerformed( ActionEvent arg0 ) 
			{
				int i_deporte     = Integer.parseInt( comboBox_i_deporte.getSelectedItem().toString() );
				int i_musica      = Integer.parseInt( comboBox_i_musica.getSelectedItem().toString() );
				int i_espectaculo = Integer.parseInt( comboBox_i_espectaculo.getSelectedItem().toString() );
				int i_ciencia     = Integer.parseInt( comboBox_i_ciencia.getSelectedItem().toString() );
				String nombre     = textFieldNombre.getText();
				
				if( !nombre.trim().isEmpty() && !nombre.equals( "Falta nombre" ) ) {
					principal.agregarPersona( nombre, i_deporte, i_musica, i_espectaculo, i_ciencia );
					
					textArea.append( "" + nombre + " " + i_deporte + " " + i_musica + " " + i_espectaculo
							+ " " + i_ciencia + " \n" );
					
					textFieldNombre.setText( null );
					textFieldNombre.requestFocusInWindow();
					
					reiniciarComboBox( comboBox_i_deporte, comboBox_i_musica, comboBox_i_espectaculo,
							comboBox_i_ciencia );
				}
				else 
				{
					textFieldNombre.setForeground( Color.RED );
					textFieldNombre.setText( "Falta nombre" );
					textFieldNombre.addFocusListener( new FocusAdapter() {
						@Override
						public void focusGained( FocusEvent e ) 
						{
							textFieldNombre.setText( null );
							textFieldNombre.setForeground( Color.BLACK );
						}
					} );
				}
			}
		} );
		btnAgregarPersona.setBounds( 78, 288, 129, 36 );
		panel.add( btnAgregarPersona );
		
		
		
		
		JButton btnCrearGrupos = new JButton( "" );
		movimientoBotonCrear (btnCrearGrupos );
		btnCrearGrupos.setIcon( new ImageIcon( Carga_automatica.class.getResource( "/imagenes/CREAR-GRUPOS.png" ) ) );
		btnCrearGrupos.setFocusPainted( false );
		btnCrearGrupos.setBorderPainted( false );
		btnCrearGrupos.setBackground( new Color( 29, 35, 38 ) );
		btnCrearGrupos.setBounds( 115, 513, 184, 34 );
		btnCrearGrupos.addActionListener( new ActionListener() 
		{
			public void actionPerformed( ActionEvent arg0 ) 
			{
				if( principal.tamanoListaPersonas() >= 2 )
				{
					ArrayList< String > listaA = principal.crearGrupos().get( 0 );
					ArrayList< String > listaB = principal.crearGrupos().get( 1 );

					imprimirGrupos( listaA, listaB );
					btnCrearGrupos.setEnabled( false );
					btnAgregarPersona.setEnabled( false );
					lblSugerenciaVolver.setVisible( true );
				}
				else 
				{
					JOptionPane.showMessageDialog( null, "Minimo 2 personas para agrupar" );
				}
			}
		} );
		frame.getContentPane().add( btnCrearGrupos );
		
		
		
		
		botonSalir = new JLabel( "" );
		botonSalir.setBounds( 766, 11, 24, 31 );
		botonSalir.addMouseListener( new MouseAdapter() 
		{
			@Override
			public void mouseClicked( MouseEvent arg0 ) 
			{
				System.exit( 0 );
			}
		} );
		botonSalir.setIcon (new ImageIcon( Carga_manual.class.getResource( "/imagenes/boton-salir.png" ) ) );
		frame.getContentPane().add( botonSalir );
		
		
		
		
		JLabel lblHechoPor = new JLabel( "Hecho por Elias Go\u00F1ez" );
		lblHechoPor.setForeground( new Color( 29, 35, 38 ) );
		lblHechoPor.setBounds( 57, 28, 131, 14 );
		frame.getContentPane().add( lblHechoPor );
		lblHechoPor.setVisible( false );
		
		
		
		
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
		botonVolver.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked( MouseEvent arg0 ) 
			{
				Inicio inicio = new Inicio();
				inicio.getFrame().setVisible( true );
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
	
	
	@SuppressWarnings("rawtypes")
	private void reiniciarComboBox( JComboBox comboBox_i_deporte, JComboBox comboBox_i_musica,
			JComboBox comboBox_i_espectaculo, JComboBox comboBox_i_ciencia ) 
	{
		comboBox_i_ciencia.setSelectedIndex( 0 );
		comboBox_i_deporte.setSelectedIndex (0 );
		comboBox_i_espectaculo.setSelectedIndex ( 0 );
		comboBox_i_musica.setSelectedIndex( 0 );
	}
	
	
	
	
	private void imprimirGrupos( ArrayList<String> listaA, ArrayList<String> listaB ) 
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
	
	
	
	
	@SuppressWarnings("unchecked")
	private void crearComboBox( @SuppressWarnings("rawtypes") JComboBox cBox ) 
	{
		cBox.addItem( "1" );
		cBox.addItem( "2" );
		cBox.addItem( "3" );
		cBox.addItem( "4" );
		cBox.addItem( "5" );
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
	
	
	
	
	
	private void movimientoBotonAgregar( JButton boton ) 
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

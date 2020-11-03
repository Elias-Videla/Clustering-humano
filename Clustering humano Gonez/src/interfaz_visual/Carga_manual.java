package interfaz_visual;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Carga_manual {

	public JFrame frame;
	private JTextField textFieldNombre;
	private JTextArea textArea;

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
	public Carga_manual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Principal p = new Principal();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(221, 220, 197));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBounds(415, 63, 345, 396);
		frame.getContentPane().add(textArea);
		textArea.append("Nombre    " + "| Deportes | Musica | Espectaculo | Ciencia \n");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(149, 137, 118));
		panel.setBounds(41, 87, 290, 355);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 76, 58, 14);
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) 
			{
				if (textFieldNombre.getText().length()== 12) 
			         arg0.consume(); 
			}
		});
		textFieldNombre.setFont(new Font("Arial Black", Font.PLAIN, 13));
		textFieldNombre.setBounds(90, 74, 136, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		
		
		
		JLabel lblInteresDeporte = new JLabel("Interes deporte:");
		lblInteresDeporte.setBounds(22, 115, 106, 14);
		panel.add(lblInteresDeporte);
		
		JLabel lblInteresMusica = new JLabel("Interes musica:");
		lblInteresMusica.setBounds(20, 159, 106, 14);
		panel.add(lblInteresMusica);
		
		JLabel lblInteresEspectaculo = new JLabel("Interes espectaculo:");
		lblInteresEspectaculo.setBounds(20, 198, 123, 14);
		panel.add(lblInteresEspectaculo);
		
		JLabel lblInteresCiencia = new JLabel("Interes ciencia:");
		lblInteresCiencia.setBounds(21, 234, 95, 14);
		panel.add(lblInteresCiencia);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_i_deporte = new JComboBox();
		comboBox_i_deporte.setBounds(136, 114, 37, 20);
		panel.add(comboBox_i_deporte);
		crearComboBox(comboBox_i_deporte);

		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_i_musica = new JComboBox();
		comboBox_i_musica.setBounds(138, 156, 37, 20);
		panel.add(comboBox_i_musica);
		crearComboBox(comboBox_i_musica);

		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_i_espectaculo = new JComboBox();
		comboBox_i_espectaculo.setBounds(140, 196, 37, 20);
		panel.add(comboBox_i_espectaculo);
		crearComboBox(comboBox_i_espectaculo);

		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_i_ciencia = new JComboBox();
		comboBox_i_ciencia.setBounds(141, 230, 37, 20);
		panel.add(comboBox_i_ciencia);
		crearComboBox(comboBox_i_ciencia);
		
		
		
		JButton btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int i_deporte     = Integer.parseInt(comboBox_i_deporte.getSelectedItem().toString());
				int i_musica      = Integer.parseInt(comboBox_i_musica.getSelectedItem().toString());
				int i_espectaculo = Integer.parseInt(comboBox_i_espectaculo.getSelectedItem().toString());
				int i_ciencia     = Integer.parseInt(comboBox_i_ciencia.getSelectedItem().toString());
				String nombre     = textFieldNombre.getText();
				
				if(!nombre.trim().isEmpty()) {
					p.agregarPersona(nombre, i_deporte, i_musica, i_espectaculo, i_ciencia);

					//hacer metodo para agregar el texto en el textarea
					textArea.append("" + nombre + " " + i_deporte + " " + i_musica + " " + i_espectaculo
							+ " " + i_ciencia + " \n");
					textFieldNombre.setText(null);
					
					reiniciarComboBox(comboBox_i_deporte, comboBox_i_musica, comboBox_i_espectaculo,
							comboBox_i_ciencia);
				}
				else 
				{
					textFieldNombre.setForeground(Color.RED);
					textFieldNombre.setText("Falta nombre");
					textFieldNombre.addFocusListener(new FocusAdapter() {
						@Override
						public void focusGained(FocusEvent e) 
						{
							textFieldNombre.setText(null);
							textFieldNombre.setForeground(Color.BLACK);
						}
					});
				}
			}
		});
		btnAgregarPersona.setBounds(93, 273, 89, 23);
		panel.add(btnAgregarPersona);
		
		
		
		JButton btnCrearGrupos = new JButton("Crear grupos");
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
		btnCrearGrupos.setBounds(143, 477, 119, 23);
		frame.getContentPane().add(btnCrearGrupos);
		
		
		
	}
	
	@SuppressWarnings("rawtypes")
	private void reiniciarComboBox(JComboBox comboBox_i_deporte, JComboBox comboBox_i_musica,
			JComboBox comboBox_i_espectaculo, JComboBox comboBox_i_ciencia) {
		comboBox_i_ciencia.setSelectedIndex(0);
		comboBox_i_deporte.setSelectedIndex(0);
		comboBox_i_espectaculo.setSelectedIndex(0);
		comboBox_i_musica.setSelectedIndex(0);
	}
	
	private void imprimirGrupos(ArrayList<String> listaA, ArrayList<String> listaB) 
	{
		textArea.setText(null);
		textArea.append("Grupo 1 \n");
		System.out.println("Grupo 1 \n");
		for(int i = 0; i < listaA.size()/2; i++) 
		{
			textArea.append(listaA.get(i) + " ");
		}
		
		textArea.append("\nGrupo 2\n");
		for(int i = 0; i < listaB.size()/2; i++) 
		{
			textArea.append(listaB.get(i) + " ");
		}
	}
	
	@SuppressWarnings("unchecked")
	private void crearComboBox(@SuppressWarnings("rawtypes") JComboBox cBox) 
	{
		cBox.addItem("1");
		cBox.addItem("2");
		cBox.addItem("3");
		cBox.addItem("4");
		cBox.addItem("5");
	}
}

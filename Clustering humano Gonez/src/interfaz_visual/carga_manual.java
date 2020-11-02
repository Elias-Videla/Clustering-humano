package interfaz_visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;

public class carga_manual {

	private JFrame frame;
	private JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carga_manual window = new carga_manual();
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
	public carga_manual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(415, 63, 345, 396);
		frame.getContentPane().add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 87, 290, 355);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 76, 58, 14);
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(90, 74, 86, 20);
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
		
		JComboBox comboBox_i_deporte = new JComboBox();
		comboBox_i_deporte.setBounds(136, 114, 37, 20);
		panel.add(comboBox_i_deporte);
		comboBox_i_deporte.addItem("1");
		comboBox_i_deporte.addItem("2");
		comboBox_i_deporte.addItem("3");
		comboBox_i_deporte.addItem("4");
		comboBox_i_deporte.addItem("5");
		
		JComboBox comboBox_i_musica = new JComboBox();
		comboBox_i_musica.setBounds(138, 156, 37, 20);
		panel.add(comboBox_i_musica);
		comboBox_i_musica.addItem("1");
		comboBox_i_musica.addItem("2");
		comboBox_i_musica.addItem("3");
		comboBox_i_musica.addItem("4");
		comboBox_i_musica.addItem("5");
		
		JComboBox comboBox_i_espectaculo = new JComboBox();
		comboBox_i_espectaculo.setBounds(140, 196, 37, 20);
		panel.add(comboBox_i_espectaculo);
		comboBox_i_espectaculo.addItem("1");
		comboBox_i_espectaculo.addItem("2");
		comboBox_i_espectaculo.addItem("3");
		comboBox_i_espectaculo.addItem("4");
		comboBox_i_espectaculo.addItem("5");
		
		JComboBox comboBox_i_ciencia = new JComboBox();
		comboBox_i_ciencia.setBounds(141, 230, 37, 20);
		panel.add(comboBox_i_ciencia);
		comboBox_i_ciencia.addItem("1");
		comboBox_i_ciencia.addItem("2");
		comboBox_i_ciencia.addItem("3");
		comboBox_i_ciencia.addItem("4");
		comboBox_i_ciencia.addItem("5");
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(93, 273, 89, 23);
		panel.add(btnCrear);
	}
}

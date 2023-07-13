package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * Clase para crear una ventana para mostrar el tipo de cambio utilizado en la conversion de divisas.
 * @author Gerardo Santana
 * @version 1.0
 */
public class VentanaTipoDeCambio extends JFrame {

	private JPanel panelTipoDeCambio;
	
	/**
	 * Metodo constructor de la clase.
	 * Define el titulo y el tamaño de la ventana. Despues invoca a otro metodo para inicializas los componentes de la ventana.
	 */
	public VentanaTipoDeCambio() {
		setTitle("Tasas de cambio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(690, 210);
		componentes();
	}
	
	/**
	 * Metodo que crea la ventana y sus componentes y los muestra.
	 */
	private void componentes() {
		panelTipoDeCambio = new JPanel();
		panelTipoDeCambio.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelTipoDeCambio);
		panelTipoDeCambio.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Documentos\\conversor-one-g5\\conversor_divisas\\TipoDeCambio.png"));
		lblNewLabel.setBounds(0, 0, 673, 168);
		panelTipoDeCambio.add(lblNewLabel);
		
		setLocation(400, 50);
		setResizable(false);
	}
}

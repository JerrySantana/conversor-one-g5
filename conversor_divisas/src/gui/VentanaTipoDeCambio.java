package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class VentanaTipoDeCambio extends JFrame {

	private JPanel panelTipoDeCambio;

	/**
	 * Create the frame.
	 */
	public VentanaTipoDeCambio() {
		setTitle("Tasas de cambio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(690, 210);
		componentes();
		
	}
	
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

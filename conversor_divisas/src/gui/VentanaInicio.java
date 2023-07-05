package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

	private JPanel panelPrincipal;
	
	// Crea la ventana de selección inicial.
	public VentanaInicio() {
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(280, 210);
		componentes();
	}
	
	// Crea y muestra la ventana y sus componentes.
	private void componentes() {
		panelPrincipal = new JPanel();
		setContentPane(panelPrincipal);
		
		JLabel lblPregunta = new JLabel("¿Qué deseas convertir?");
		lblPregunta.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPregunta.setBounds(30, 10, 200, 30);
		getContentPane().add(lblPregunta);
		
		JComboBox cbTipoConversion = new JComboBox();
		cbTipoConversion.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		cbTipoConversion.setModel(new DefaultComboBoxModel(new String[] {"Divisas", "Peso"}));
		cbTipoConversion.setBounds(15, 60, 240, 35);
		getContentPane().add(cbTipoConversion);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbTipoConversion.getSelectedItem() == "Divisas") {
					dispose();
					new VentanaDivisas().setVisible(true);
				} else {
					
				}
			}
		});
		btnSiguiente.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		btnSiguiente.setBounds(15, 112, 108, 30);
		getContentPane().add(btnSiguiente);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		btnSalir.setBounds(147, 112, 108, 30);
		getContentPane().add(btnSalir);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		
		
	}
}

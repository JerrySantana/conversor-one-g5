package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversor.Divisa;
import conversor.Divisas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDivisas extends JFrame implements ActionListener {

	private JPanel panelDivisas;
	private JTextField valorDivisa;
	private JComboBox<?> cbDe;
	private JComboBox<?> cbA;
	private JButton btnConvertir;
	private JLabel lblResultado;

	// Crea la ventana de conversión de divisas.
	public VentanaDivisas() {
		setTitle("Conversor Divisas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 290);
		componentes();
	}

	// Crea y muestra la ventana y sus componentes.
	private void componentes() {
		panelDivisas = new JPanel();
		setContentPane(panelDivisas);
		panelDivisas.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDivisas.setLayout(null);

		JLabel lblConversion = new JLabel("Ingresa el valor a convertir:");
		lblConversion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversion.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblConversion.setBounds(65, 10, 240, 30);
		panelDivisas.add(lblConversion);

		valorDivisa = new JTextField();
		valorDivisa.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		valorDivisa.setBounds(85, 50, 200, 30);
		panelDivisas.add(valorDivisa);
		valorDivisa.setColumns(10);

		JLabel lblDe = new JLabel("De:");
		lblDe.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblDe.setBounds(65, 90, 30, 30);
		panelDivisas.add(lblDe);

		JLabel lblA = new JLabel("A:");
		lblA.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblA.setBounds(275, 90, 20, 30);
		panelDivisas.add(lblA);

		cbDe = new JComboBox();
		cbDe.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		cbDe.setModel(new DefaultComboBoxModel(
				new Divisas[] { Divisas.Dolar, Divisas.Euro, Divisas.Libras, Divisas.Yen, Divisas.KRW, Divisas.MXN }));
		cbDe.setBounds(10, 120, 140, 30);
		panelDivisas.add(cbDe);

		cbA = new JComboBox();
		cbA.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		cbA.setModel(new DefaultComboBoxModel(
				new Divisas[] { Divisas.Dolar, Divisas.Euro, Divisas.Libras, Divisas.Yen, Divisas.KRW, Divisas.MXN }));
		cbA.setBounds(210, 120, 140, 30);
		panelDivisas.add(cbA);

		btnConvertir = new JButton("Convertir");
		btnConvertir.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
		btnConvertir.setBounds(10, 168, 100, 30);
		btnConvertir.addActionListener(this);
		panelDivisas.add(btnConvertir);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicio().setVisible(true);
			}
		});
		btnVolver.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		btnVolver.setBounds(60, 215, 100, 30);
		panelDivisas.add(btnVolver);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		btnSalir.setBounds(200, 215, 100, 30);
		panelDivisas.add(btnSalir);

		JLabel lblTotal = new JLabel("El total es:");
		lblTotal.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblTotal.setBounds(110, 170, 88, 30);
		panelDivisas.add(lblTotal);

		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblResultado.setBounds(200, 170, 166, 30);
		panelDivisas.add(lblResultado);

		setLocationRelativeTo(null);
		setResizable(false);
	}

	// Realiza la conversion al clickear el boton convertir.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConvertir) {
			Divisa resultado = null;
			try {
				lblResultado.setText("");
				double valor = Double.parseDouble(valorDivisa.getText());
				Divisas origen = (Divisas) cbDe.getSelectedItem();
				Divisas destino = (Divisas) cbA.getSelectedItem();
				resultado = new Divisa(origen, destino, valor);
				lblResultado.setText(resultado.convertir() + " " + destino.name());
			} catch (NumberFormatException ex) {
				lblResultado.setText("Valor inválido.");
				JOptionPane.showMessageDialog(null, "Valor inválido, revisa los datos ingresados.", "Valor inválido.",
						JOptionPane.ERROR_MESSAGE);
			} catch (NullPointerException ex) {
				lblResultado.setText("");
				JOptionPane.showMessageDialog(null, "Hubo un problema, intentalo nuevamente.", "Problema de ejecución",
						JOptionPane.ERROR_MESSAGE);
			} finally {
				valorDivisa.setText("");
			}
		}
	}
}

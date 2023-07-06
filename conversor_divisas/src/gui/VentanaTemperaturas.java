package gui;

import conversor.Temperaturas;
import conversor.Temperatura;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaTemperaturas extends JFrame implements ActionListener {

	private JPanel panelTemperaturas;
	private JTextField valorTemperatura;
	private JComboBox cbGradosOrigen;
	private JComboBox cbGradosDestino;
	private JButton btnConvertirGrados;
	private JLabel lblResultado;
	private JTable table;

	/**
	 * Crea la ventana de conversion de temperaturas en grados.
	 */
	public VentanaTemperaturas() {
		setTitle("Conversor Temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 350);
		componentes();
	}

	private void componentes() {
		panelTemperaturas = new JPanel();
		setContentPane(panelTemperaturas);
		panelTemperaturas.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelTemperaturas.setLayout(null);

		JLabel lblTemperatura = new JLabel("Ingresa la temperatura a convertir:");
		lblTemperatura.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperatura.setBounds(36, 0, 308, 30);
		panelTemperaturas.add(lblTemperatura);

		valorTemperatura = new JTextField();
		valorTemperatura.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		valorTemperatura.setBounds(100, 40, 100, 30);
		panelTemperaturas.add(valorTemperatura);
		valorTemperatura.setColumns(10);

		JLabel lblGrados = new JLabel("(grados)");
		lblGrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrados.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblGrados.setBounds(200, 40, 80, 30);
		panelTemperaturas.add(lblGrados);

		cbGradosOrigen = new JComboBox();
		cbGradosOrigen.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		cbGradosOrigen.setModel(new DefaultComboBoxModel(
				new Temperaturas[] { Temperaturas.Celsius, Temperaturas.Fahrenheit, Temperaturas.Kelvin }));
		cbGradosOrigen.setBounds(60, 100, 115, 30);
		panelTemperaturas.add(cbGradosOrigen);

		JLabel lblGradosDe = new JLabel("De:");
		lblGradosDe.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblGradosDe.setBounds(60, 70, 29, 30);
		panelTemperaturas.add(lblGradosDe);

		cbGradosDestino = new JComboBox();
		cbGradosDestino.setModel(new DefaultComboBoxModel(
				new Temperaturas[] { Temperaturas.Celsius, Temperaturas.Fahrenheit, Temperaturas.Kelvin }));
		cbGradosDestino.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		cbGradosDestino.setBounds(210, 100, 115, 30);
		panelTemperaturas.add(cbGradosDestino);

		JLabel lblGradosA = new JLabel("A:");
		lblGradosA.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblGradosA.setBounds(210, 70, 18, 30);
		panelTemperaturas.add(lblGradosA);

		btnConvertirGrados = new JButton("Convertir");
		btnConvertirGrados.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		btnConvertirGrados.setBounds(10, 150, 110, 30);
		btnConvertirGrados.addActionListener(this);
		panelTemperaturas.add(btnConvertirGrados);

		JLabel lblTotal = new JLabel("El total es:");
		lblTotal.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblTotal.setBounds(120, 150, 88, 30);
		panelTemperaturas.add(lblTotal);

		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblResultado.setBounds(210, 150, 166, 30);
		panelTemperaturas.add(lblResultado);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicio().setVisible(true);
			}
		});
		btnVolver.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		btnVolver.setBounds(60, 264, 100, 30);
		panelTemperaturas.add(btnVolver);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		btnSalir.setBounds(225, 264, 100, 30);
		panelTemperaturas.add(btnSalir);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, "Celsius", "Fahrenheit", "Kelvin" },
						{ "Celsius", "1 \u00B0C", "33.8 \u00B0F", "274.15 K" },
						{ "Fahrenheit", "-17.222 \u00B0C", "1 \u00B0F", "255.928 K" },
						{ "Kelvin", "-272.15 \u00B0C", null, "1 K" }, },
				new String[] { "", "Celsius", "Fahrenheit", "Kelvin" }));
		table.setBounds(10, 190, 366, 64);
		panelTemperaturas.add(table);

		setLocationRelativeTo(null);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConvertirGrados) {
			Temperatura resultado = null;
			try {
				lblResultado.setText("");
				double valor = Double.parseDouble(valorTemperatura.getText());
				Temperaturas origen = (Temperaturas) cbGradosOrigen.getSelectedItem();
				Temperaturas destino = (Temperaturas) cbGradosDestino.getSelectedItem();
				resultado = new Temperatura(origen, destino, valor);
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
				valorTemperatura.setText("");
			}
		}

	}
}

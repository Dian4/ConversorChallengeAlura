package com.starblackdian.conversoralura.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.List;
import java.awt.TrayIcon.MessageType;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;

import com.starblackdian.conversoralura.controller.ConversionController;
import com.starblackdian.conversoralura.enums.DivisaEnum;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frmConversorDeMonedas;
	private JTextField txtCantidad;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmConversorDeMonedas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversorDeMonedas = new JFrame();
		frmConversorDeMonedas.setResizable(false);
		frmConversorDeMonedas.setTitle("Conversor de Monedas Alura");
		frmConversorDeMonedas.setBounds(100, 100, 662, 255);
		frmConversorDeMonedas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversorDeMonedas.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frmConversorDeMonedas.getContentPane().add(panel);
		
		JComboBox cmbDivisaOrigen = new JComboBox();
		cmbDivisaOrigen.setModel(new DefaultComboBoxModel(DivisaEnum.values()));
		
		JLabel lblNewLabel = new JLabel("Conversor de Monedas Gatunas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Convertir de:");
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("a:");
		
		txtResultado = new JTextField();
		txtResultado.setEditable(false);
		txtResultado.setColumns(10);
		
		JComboBox cmbDivisaDestino = new JComboBox();
		cmbDivisaDestino.setModel(new DefaultComboBoxModel(DivisaEnum.values()));
		
		JButton btnConvertir = new JButton("¡Convertir!");
		btnConvertir.addActionListener(e -> {
			try {
				final String textoCantidad = txtCantidad.getText();
				final DivisaEnum divisaOrigen = (DivisaEnum) cmbDivisaOrigen.getSelectedItem();
				final DivisaEnum divisaDestino = (DivisaEnum) cmbDivisaDestino.getSelectedItem();
				
				final ConversionController controller = new ConversionController();
				final BigDecimal resultado = controller.convertir(textoCantidad, divisaOrigen, divisaDestino);
				
				txtResultado.setText(resultado.toString());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frmConversorDeMonedas, "Por favor introduzca un valor numérico. Usted Erró.");
				txtCantidad.setText("");
			}
		});
		
		JButton btnInvertir = new JButton("Invertir");
		btnInvertir.addActionListener(e -> {
			final String resultado = txtResultado.getText();
			txtCantidad.setText(resultado);
			txtResultado.setText("");
			
			final DivisaEnum divisaOrigen = (DivisaEnum) cmbDivisaOrigen.getSelectedItem();
			final DivisaEnum divisaDestino = (DivisaEnum) cmbDivisaDestino.getSelectedItem();
			
			cmbDivisaOrigen.setSelectedItem(divisaDestino);
			cmbDivisaDestino.setSelectedItem(divisaOrigen);
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(214)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(171, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(104)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtCantidad, Alignment.LEADING)
						.addComponent(cmbDivisaOrigen, Alignment.LEADING, 0, 165, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnInvertir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnConvertir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbDivisaDestino, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtResultado, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
					.addGap(72))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbDivisaOrigen, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbDivisaDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConvertir))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtResultado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnInvertir))))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}

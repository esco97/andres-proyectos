package escobar.andres.formacion.ejemplos;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class SwingEjemplo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		JFrame jf = new JFrame("Mi ventana");
		jf.setVisible(true);
		
		Container contentPane = jf.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel lblNombre = new JLabel("Nombre");
		contentPane.add(lblNombre);
		
		JTextField txtNombre = new JTextField(10);
		contentPane.add(txtNombre);
		
		JButton btnSaludar = new JButton("Saludar");
		contentPane.add(btnSaludar);
		
		JLabel lblResultado = new JLabel("");
		contentPane.add(lblResultado);
		
		jf.pack();
		
		btnSaludar.addActionListener(e -> {
			lblResultado.setText("Hola " + txtNombre.getText());
			jf.pack();
		});
	}
}

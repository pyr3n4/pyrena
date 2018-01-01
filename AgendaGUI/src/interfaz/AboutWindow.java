package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dominio.Contacto;

import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutWindow extends JFrame {
	
	private JPanel panel;
	private JPanel buttonsPanel;
	private JButton OK;
	private JPanel formPanel;
	
	private MainWindow mainGui; //Ventana principal de la aplicación
	private Contacto myContact;

	public AboutWindow() {
		
		super();
		
		
		initComponents();
		
	}
	
	

	private void initComponents() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutWindow.class.getResource("/imagenes/262f.png")));
		setPreferredSize(new Dimension(400, 300));
		setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 14));
		setResizable(false);
		setBounds(new Rectangle(100, 100, 0, 0));
		setTitle("About ");
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		buttonsPanel = new JPanel();
		panel.add(buttonsPanel, BorderLayout.SOUTH);
		
		OK = new JButton("OK!");
		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				exitWindow();
				
			}
		});
		buttonsPanel.add(OK);
		getRootPane().setDefaultButton(OK);
		
		formPanel = new JPanel();
		panel.add(formPanel, BorderLayout.CENTER);
		formPanel.setLayout(null);
		
		JTextPane textPaneAbout = new JTextPane();
		textPaneAbout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPaneAbout.setEditable(false);
		textPaneAbout.setBackground(UIManager.getColor("Button.background"));
		textPaneAbout.setText("                     Version: 1.0  Build id: 001-223 \n\n(c) Copyright Pyrena contributors and others 2016, 2017.\n\n"
				+ "                             All rights deserved. \n\nThe Agenda logo cannot be altered without Pyrena´s permission. \n\n"
				+ "            \n          THANKS TO ALL 1stDAW IES LA SÈNIA TEAM");
		textPaneAbout.setBounds(12, 13, 370, 204);
		formPanel.add(textPaneAbout);
		
		pack();
		
	}

	
	
		//***************************************************************************************
		// Acciones de los botones de la ventana maxim-minim-close
		//***************************************************************************************
		private void windowClosingPerformed(java.awt.event.WindowEvent e) {

			this.exitWindow();	
		}
		
		//***************************************************************************************
		//Acciones de los items del menú (Salida etc.) 
		//***************************************************************************************
		
		private void exitWindow(){
			//TODO implementar método para salir de la ventana editable
			this.dispose();
		}
}//class

package interfaz;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Event;

import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;





public class ControlAccess extends JDialog {
	
	
	//Atributos	
	
	private int nCuenta = 0;
	
	private JPanel panel;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnGO;
	private JButton btnCancel;
	private JLabel lblyouHave;
	
	private JFrame mainFrame;
	
	//constructor
	public ControlAccess(JFrame mainGui, boolean modal) {
		
		super(mainGui,modal);
		
		this.mainFrame = mainGui;
		initComponents();
		
	}
	
	
	//getter
	
	public JPasswordField getPasswordField() {
		return passwordField;
	}



	
	private void initComponents(){
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mainFrame.setVisible(false);
				System.exit(0);
			}
		});
		
		
		setTitle("Control Access");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ControlAccess.class.getResource("/imagenes/1f510.png")));
		setBounds(new Rectangle(500, 250, 0, 0));
		getContentPane().setSize(new Dimension(300, 200));
		setSize(new Dimension(300, 200));
		setPreferredSize(new Dimension(300, 200));
		setResizable(false);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 33, 155, 25);
		passwordField.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordField.setPreferredSize(new Dimension(100, 25));
		passwordField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt){
				passwordField.selectAll();
			}
		});
		panel.add(passwordField);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 37, 104, 16);
		panel.add(lblPassword);
		
		lblyouHave = new JLabel("(You have a total of 3 attempts)");
		lblyouHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblyouHave.setBounds(22, 71, 260, 16);
		panel.add(lblyouHave);
		
		btnGO = new JButton("Access");
		
		btnGO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				passwordOk();
			}
		});
		btnGO.setBounds(44, 113, 97, 25);
		panel.add(btnGO);
		getRootPane().setDefaultButton(btnGO);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				System.exit(0); //Si cancelamos el control de acceso se cierra la aplicación
			}
		});
		btnCancel.setBounds(158, 113, 97, 25);
		panel.add(btnCancel);
		
		
		
		
		
	}

	//***************************************************************************************
		// Seguridad
		//***************************************************************************************	
		
	 private void passwordOk() {  //visibilidad package
		//se admiten 3 intentos
						
			String palabraDePaso = null;
			
			
				//coger la contraseña introducida
				palabraDePaso = String.valueOf(this.getPasswordField().getPassword());
					
					//compararla con la contraseña y si campo lleno y no hay coincidencia 
					if(palabraDePaso != null && palabraDePaso.compareTo("petete") !=0){
						
						nCuenta++;
						passwordField.setText("");
						passwordField.requestFocus();
						JOptionPane.showMessageDialog(null, "Wrong password", "Error", JOptionPane.ERROR_MESSAGE);			
						
						//break:
						if(nCuenta==3){//si el tercer intento ha sido fallido
							nCuenta = 0; //resetear contador y salir app
							System.exit(0);
							
							
						}
												
				//si no, si el campo está vacío o el contador es 3 (intentos fallidos)	
					}else if(palabraDePaso == null || nCuenta == 3) { //no hay texto o ya habíamos alcanzado el num intentos
							
							nCuenta = 0; //inicializamos contador para la próxima
							System.exit(0);//saldremos de la aplicación
						}
							//si no, es que la palabra es correcta, 
						else {
							nCuenta = 0; //inicializamos contador para la próxima
							dispose(); //se cerrará la ventana y dejará acceso a app
							mainFrame.setVisible(true);
						}
						
			
			
					
	}
				
			
			
				
		 



	
		
	
}//class

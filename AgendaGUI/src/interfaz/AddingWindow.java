package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dominio.Agenda;
import dominio.Contacto;

import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.InputMismatchException;
import java.util.regex.Pattern;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

import org.omg.CORBA.TRANSACTION_MODE;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class AddingWindow extends JFrame{
	
	private JTextField textField_EditableName;
	private JTextField textField_EditableSurname;
	private JTextField textField_EditableAge;
	private JTextField textField_EditablePhone;
	private JTextField textField_EditableCity;
	private JPanel panel;
	private JPanel buttonsPanel;
	private JButton btnSave;
	private JButton btnGoBack;
	private JPanel formPanel;
	private JLabel lblEditableName;
	
	private JLabel lblEditableSurname;
	private JLabel lblEditableAge;
	private JLabel lblTelephoneNumber;
	private JLabel lblSex;
	private JComboBox<String> comboBoxSex;
	private JLabel lblCity;
	
	private MainWindow mainGui; //Ventana principal de la aplicación
	private Agenda addssBook;	//Agenda
	private Contacto myContact; //Contacto

	
	
	//constructor al que se le pasan la interfaz principal y la agenda
	public AddingWindow(MainWindow mainGui, Agenda addssBook){ 
		
		super();
		setTitle("Add Contact");
		this.mainGui = mainGui;
		this.addssBook = addssBook;
		
		
		initComponents();
		
	}
	
	
	private void initComponents() {
		
		setType(Type.NORMAL); 
		
		
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						mainGui.setVisible(true);
						dispose();
					}
				});
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddingWindow.class.getResource("/imagenes/262f.png")));
		setBounds(new Rectangle(500, 300, 0, 0));
		setPreferredSize(new Dimension(400, 300));
		setResizable(false);
		getContentPane().setName("");
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		buttonsPanel = new JPanel();
		panel.add(buttonsPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("Save Contact");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addContactData(mainGui,addssBook);
			}

			
		});
		buttonsPanel.add(btnSave);
		getRootPane().setDefaultButton(btnSave);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				goBack();
			}
		});
		buttonsPanel.add(btnGoBack);
		
		
		formPanel = new JPanel();
		panel.add(formPanel, BorderLayout.CENTER);
		formPanel.setLayout(null);
		
		lblEditableName = new JLabel("Name*");
		lblEditableName.setBounds(43, 33, 56, 16);
		formPanel.add(lblEditableName);
		
		textField_EditableName = new JTextField();
		textField_EditableName.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_EditableName.setBounds(117, 30, 250, 22);
		formPanel.add(textField_EditableName);
		textField_EditableName.setColumns(10);
		
		textField_EditableName.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt){
				jtbFocusGained(evt);
			}

			
		});
		
		lblEditableSurname = new JLabel("Surname*");
		lblEditableSurname.setBounds(43, 62, 56, 16);
		formPanel.add(lblEditableSurname);
		
		textField_EditableSurname = new JTextField();
		textField_EditableSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_EditableSurname.setColumns(10);
		textField_EditableSurname.setBounds(117, 62, 250, 22);
		formPanel.add(textField_EditableSurname);
		textField_EditableSurname.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt){
				jtbFocusGained(evt);
			}

			
		});
		
		lblEditableAge = new JLabel("Age*");
		lblEditableAge.setBounds(43, 100, 56, 16);
		formPanel.add(lblEditableAge);
		
		textField_EditableAge = new JTextField();
		textField_EditableAge.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_EditableAge.setColumns(10);
		textField_EditableAge.setBounds(117, 97, 50, 22);
		formPanel.add(textField_EditableAge);
		textField_EditableAge.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt){
				jtbFocusGained(evt);
			}

			
		});
		
		
		lblTelephoneNumber = new JLabel("Phone Number*");
		lblTelephoneNumber.setBounds(43, 141, 100, 16);
		formPanel.add(lblTelephoneNumber);
		
		
		//crear un manejador de eventos de tipo keyAdapter (keyListener)
		//y asociarlo con la caja de texto para el TELÉFONO
		
		textField_EditablePhone = new JTextField();
		textField_EditablePhone.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_EditablePhone.setColumns(10);
		textField_EditablePhone.setBounds(167, 138, 200, 22);
		formPanel.add(textField_EditablePhone);
		//  textField_EditablePhone.addKeyListener(this);  //manejador eventos
		
		textField_EditablePhone.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt){
				jtbFocusGained(evt);
			}

			
		});
		
		lblSex = new JLabel("Sex*");
		lblSex.setBounds(202, 100, 56, 16);
		formPanel.add(lblSex);
		
		String[] sexos = {"M", "F", "O"};
		comboBoxSex = new JComboBox<String>(sexos);
		comboBoxSex.setToolTipText("M (Male) / F (Female) / O (Other)");
		comboBoxSex.setBackground(Color.WHITE);
		comboBoxSex.setBounds(245, 97, 65, 22);
	
		formPanel.add(comboBoxSex);
		
		lblCity = new JLabel("City*");
		lblCity.setBounds(43, 170, 100, 16);
		formPanel.add(lblCity);
		
		textField_EditableCity = new JTextField();
		textField_EditableCity.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_EditableCity.setColumns(10);
		textField_EditableCity.setBounds(167, 167, 200, 22);
		formPanel.add(textField_EditableCity);
		textField_EditableCity.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt){
				jtbFocusGained(evt);
			}

			
		});
		
		pack();
		
	}

	
	//***************************************************************************************
	// selección de texto automática
	//***************************************************************************************	
	
	private void jtbFocusGained(FocusEvent evt) {
		JTextComponent jtb = (JTextComponent) evt.getSource();
		jtb.selectAll();
		
	}
	
	//***************************************************************************************
	// Check para comprobar que todos los campos están completos
	//***************************************************************************************	
	private boolean isFull(){
		//si el formulario está COMPLETO el método devuelve true
		if(!textField_EditableName.getText().isEmpty()&&
		!textField_EditableSurname.getText().isEmpty()&&
		!textField_EditableAge.getText().isEmpty()&&
		!( (String) comboBoxSex.getSelectedItem() ).isEmpty()&&
		!textField_EditablePhone.getText().isEmpty()&&
		!textField_EditableCity.getText().isEmpty()){
			return true;
		
		}else{ //Si no, es que puede faltar al menos un campo por rellenar
			JOptionPane.showMessageDialog(null, "Please, complete all fields","Warning",JOptionPane.WARNING_MESSAGE);	
			return false;
		}
	}
	
	private boolean phoneIsOk(){
		try {
			
			String source = textField_EditablePhone.getText().trim();
			
			String pattern = "(\\d{3}\\s?){3}"; //  \s y \d no son secuencias de escape válidas, 
													//por eso se han duplicado las barras
			if(Pattern.matches(pattern,source)){
				textField_EditablePhone.setText(source);
				return true;
			}else{
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Phone accepted format: 666666666 or 666 666 666","Warning",JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
						
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Phone accepted format: 666666666 or 666 666 666","Warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		
	}
	private boolean ageIsOk(){
				
		try{
			if (Integer.parseInt(this.textField_EditableAge.getText()) < 0){
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Please, type a positive number for Age field","Error",JOptionPane.ERROR_MESSAGE);
				return false;
			}else{
				return true;
			}
		}catch (NumberFormatException e) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Please, type a number for Age field","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	//***************************************************************************************
	// Acciones de los botones de la ventana 
	//***************************************************************************************	
	
	private void addContactData(MainWindow mainGui, Agenda addssBook) {
		
		
			//si el formulario está completo
			if (isFull() && ageIsOk() && phoneIsOk() ){
				//trasladar la información de los campos a variables
				String name = this.textField_EditableName.getText();
				String surname = this.textField_EditableSurname.getText();
				int age = Integer.parseInt(this.textField_EditableAge.getText());
				String sex = (String)comboBoxSex.getSelectedItem();
				String phone = this.textField_EditablePhone.getText();
				String city = this.textField_EditableCity.getText();
				
				
				//crear un contacto y guardar los datos recopilados
				Contacto contacto = new Contacto(name, surname, age, sex, phone,city);
				
				//insertar el contacto completo en la agenda (al final)
				addssBook.insertarContacto(contacto);
				mainGui.editStatusBar("Contact was added SUCCESSFULLY!");
				//obtener la posición (longitud-1) y nueva longitud de la lista
				int lenght = addssBook.getListaContactos().size();
				addssBook.setNowContact(lenght-1);
				//mostrarlo en la ventana principal
				mainGui.showContact(addssBook.getListaContactos(),lenght-1);
				//marcar que hay cambios
				addssBook.setIsChanged(true);
				//Se cierra la ventana
				mainGui.setVisible(true);
				dispose();
				
			}else{
				
				Toolkit.getDefaultToolkit().beep();
							
			
			}
						
			
		}
		
		

	
	private void goBack(){
		//hacer visible la ventana principal y cerrar la auxiliar
		mainGui.setVisible(true);
		dispose();
	}

/**
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent evt) {
		jtfPhoneKeyReleased(evt);
		
	}


	private void jtfPhoneKeyReleased(KeyEvent evt) {
		
		//obtener la caja de texto que generó el evento
		JTextField objetoJTF = (JTextField) evt.getSource();
		//almacenar el contenido de la caja de texto
		String source = objetoJTF.getText();
		String pattern = "\b(\\d{3}\\s?){3}\b"; //  \s y \d no son secuencias de escape válidas, 
												//por eso se han duplicado las barras
		if(Pattern.matches(pattern,source)){
			objetoJTF.setText(source);
		}else{
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Accepted format: 666666666 or 666 666 666","Warning",JOptionPane.WARNING_MESSAGE);
		}
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	*/
		
}//class

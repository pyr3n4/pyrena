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
import java.util.Vector;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.UIManager;

public class SearchingWindow extends JFrame {
	
	private int counter = 0;
	
	private JTextField textField_Name;
	private JTextField textField_Surname;
	private JTextField textField_Age;
	private JTextField textField_Phone;
	private JTextField textField_City;
	private JPanel panel;
	private JPanel buttonsPanel;
	private JButton btnSearch;
	private JButton btnGoBack;
	private JButton btnClearFields;
	private JLabel labelMatches;
	private JButton btnNext;
	private JPanel formPanel;
	private JLabel lblName;
	
	private JLabel lblSurname;
	private JLabel lblAge;
	private JLabel lblTelephoneNumber;
	private JLabel lblSex;
	
	private JLabel lblCity;
	
	private MainWindow mainGui; //Ventana principal de la aplicación
	private Agenda addssBook;	//Agenda
	private Contacto myContact; //Contacto
	private JTextField textField_Sex;
	private JButton button;

	
	
	//constructor al que se le pasan la interfaz principal y la agenda
	public SearchingWindow(MainWindow mainGui, Agenda addssBook){ 
		
		super();
		setResizable(false);
		setTitle("Search Contact");
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
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchingWindow.class.getResource("/imagenes/262f.png")));
		setBounds(new Rectangle(500, 300, 0, 0));
		setPreferredSize(new Dimension(400, 300));
		getContentPane().setName("");
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		
		buttonsPanel = new JPanel();
		panel.add(buttonsPanel, BorderLayout.SOUTH);
		btnSearch = new JButton("Search");
		buttonsPanel.add(btnSearch);
		getRootPane().setDefaultButton(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				searchByName();
			}

			
		});
		
		
		
		btnGoBack = new JButton("Go Back");
		buttonsPanel.add(btnGoBack);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				goBack();
			}
		});
		
		btnClearFields = new JButton("Clear");
		buttonsPanel.add(btnClearFields);
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				cleanFields();
			}
		});
		
		
		formPanel = new JPanel();
		panel.add(formPanel, BorderLayout.CENTER);
		formPanel.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setBounds(43, 33, 56, 16);
		formPanel.add(lblName);
		
		textField_Name = new JTextField();
		textField_Name.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_Name.setBounds(117, 30, 250, 22);
		formPanel.add(textField_Name);
		textField_Name.setColumns(10);
		
		
		textField_Name.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt){
				jtbFocusGained(evt);
			}

			
		});
		
		lblSurname = new JLabel("Surname");
		lblSurname.setBounds(43, 62, 56, 16);
		formPanel.add(lblSurname);
		
		textField_Surname = new JTextField();
		textField_Surname.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_Surname.setColumns(10);
		textField_Surname.setBounds(117, 62, 250, 22);
		formPanel.add(textField_Surname);
		
				
		lblAge = new JLabel("Age");
		lblAge.setBounds(43, 100, 56, 16);
		formPanel.add(lblAge);
		
		textField_Age = new JTextField();
		textField_Age.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_Age.setColumns(10);
		textField_Age.setBounds(117, 97, 50, 22);
		formPanel.add(textField_Age);
		
				
		lblTelephoneNumber = new JLabel("Phone Number");
		lblTelephoneNumber.setBounds(43, 141, 100, 16);
		formPanel.add(lblTelephoneNumber);
		
		textField_Phone = new JTextField();
		textField_Phone.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(167, 138, 200, 22);
		formPanel.add(textField_Phone);
		
				
		lblSex = new JLabel("Sex");
		lblSex.setBounds(202, 100, 56, 16);
		formPanel.add(lblSex);
		
		textField_Sex = new JTextField();
		textField_Sex.setToolTipText("M (Male) / F (Female) / O (Other)");
		textField_Sex.setText((String) null);
		textField_Sex.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_Sex.setColumns(10);
		textField_Sex.setBounds(265, 97, 50, 22);
		formPanel.add(textField_Sex);
				
		
		lblCity = new JLabel("City");
		lblCity.setBounds(43, 170, 100, 16);
		formPanel.add(lblCity);
		
		textField_City = new JTextField();
		textField_City.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_City.setColumns(10);
		textField_City.setBounds(167, 167, 200, 22);
		formPanel.add(textField_City);
		
		

		
		btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				goNext();
			}
		});
		btnNext.setBounds(307, 202, 75, 25);
		formPanel.add(btnNext);
		
		labelMatches = new JLabel("");
		labelMatches.setBackground(UIManager.getColor("Button.highlight"));
		labelMatches.setBounds(167, 201, 100, 16);
		formPanel.add(labelMatches);
		
		
		pack();
		
		enableSomeFields(false);
		setEditableSomeFields(false);
		
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
	private boolean isNameFull(){
		//si el formulario está COMPLETO el método devuelve true
		if(!this.textField_Name.getText().isEmpty()){
			return true;
		
		}else{ //Si no
				
			return false;
		}
	}
	
	
	//***************************************************************************************
	// Acciones de los botones de la ventana 
	//***************************************************************************************	
	
	private void searchByName(){
		this.counter = 0;
		if(isNameFull()){
			String name = textField_Name.getText(); //tomamos el nombre introducido
			addssBook.buscarNombre(name); //buscamos coincidencias y las añadimos en vector auxiliar
			enableSomeFields(true);
			if(!addssBook.getListaAuxiliar().isEmpty()){
				showContacts(addssBook.getListaAuxiliar(), counter);//mostrar el primero en pantalla
				btnNext.setEnabled(true);
				
			}else{
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Sorry, no coincidences","Info",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}else{
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Please, introduce the name to look for","Warning",JOptionPane.WARNING_MESSAGE);
		}
				
		
	}
	
	private void goNext(){
		
		this.counter += 1;
		if (this.counter==addssBook.getListaAuxiliar().size()){
			this.counter=0;
		}
		showContacts(addssBook.getListaAuxiliar(), counter);
	}
	
	
	private void showContacts(Vector<Contacto> c, int index){
		
		enableSomeFields(true);
		textField_Name.setEditable(false);
		this.textField_Name.setText(c.elementAt(index).getNombre());
		this.textField_Surname.setText(c.elementAt(index).getApellidos());
		this.textField_Age.setText( Integer.toString( c.elementAt(index).getEdad() ) );
		this.textField_Sex.setText(c.elementAt(index).getSexo());
		this.textField_Phone.setText(c.elementAt(index).getTelefono());
		this.textField_City.setText(c.elementAt(index).getCiudad());
		labelMatches.setText("Matches:  " + Integer.toString(addssBook.getListaAuxiliar().size()));
	}
			
	private void cleanFields() {

		textField_Name.setText("");
		textField_Name.setEditable(true);
		textField_Name.requestFocus();
		textField_Surname.setText("");
		textField_Age.setText("");
		textField_Sex.setText("");
		textField_Phone.setText("");
		textField_City.setText("");
		enableSomeFields(false);
		labelMatches.setText("");
		addssBook.getListaAuxiliar().removeAllElements();
		
		
	}
	
	private void whiteBackground(){
		textField_Name.setBackground(new Color(240, 240, 240));
		textField_Surname.setBackground(new Color(240,240,240));
		textField_Age.setBackground(new Color(240,240,240));
		textField_Sex.setBackground(new Color(240,240,240));
		textField_Phone.setBackground(new Color(240,240,240));
		textField_City.setBackground(new Color(240,240,240));
	}
	
	private void enableSomeFields(boolean flag){
		
		textField_Surname.setEnabled(flag);
		textField_Age.setEnabled(flag);
		textField_Sex.setEnabled(flag);
		textField_Phone.setEnabled(flag);
		textField_City.setEnabled(flag);
		btnNext.setEnabled(flag);
		
		labelMatches.setText("");
	}
	
	private void setEditableSomeFields(boolean flag){
		
		textField_Surname.setEditable(flag);
		textField_Age.setEditable(flag);
		textField_Sex.setEditable(flag);
		textField_Phone.setEditable(flag);
		textField_City.setEditable(flag);
		
	}
	
	
	private void goBack(){
		
		cleanFields();
		//hacer visible la ventana principal y cerrar la auxiliar
		mainGui.setVisible(true);
		dispose();
	}
}//class

package interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream.GetField;
import java.security.acl.LastOwnerException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.border.SoftBevelBorder;

import dominio.Agenda;
import dominio.Contacto;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class MainWindow extends JFrame {
	
	
	//Atributos
	
	private JMenuBar MainMenuBar;
	private JMenu mnFile;
	private JMenu mnContact;
	private JMenu mnAbout;
	
	
	private String FileToSave = "";
	
	
	private JMenuItem mnitemFileOpenBook;
	private JMenuItem mnitemFileSaveBook;
	private JMenuItem mnitemFileCloseBook;
	private JMenuItem mnitemFileExit;
	private JMenuItem mnitemContactAddContact;
	private JMenuItem mnitemContactDeleteContact;
	private JMenuItem mnitemContactEditContact;
	private JMenuItem mnitemContactSearchContact;
	private JMenu mnAppearance;
	private JMenuItem mnitemAppearanceBackground;
	private JMenuItem mnitemAppearanceRandomColors;
	private JMenuItem mnitemHelpAbout;
	private JPanel ContentPanel;
	private JToolBar ButtonsToolBar;
	private JButton btnOpenBook;
	private JButton btnSaveBook;
	private JButton btnCloseBook;
	private JButton btnExit;
	private JButton btnDeleteContact;
	private JButton btnAddContact;
	private JButton btnEditContact;
	private JButton btnSearchContact;
	private JLabel lblStatusBarLabel;
	private JPanel DownPanel;
	private JButton btnNextContact;
	private JButton btnPreviousContact;
	private JButton btnFirstContact;
	private JButton btnLastContact;
	private JPanel NavigationPanel;
	private JLabel lblContactPosition;
	private JPanel CentralContactPanel;
	private JLabel lblName;
	JTextField textField_NAME; //visibility = package
	JTextField textField_SURNAME;
	JTextField textField_AGE;
	JTextField textField_PHONE;
	JTextField textField_SEX;
	JTextField textField_CITY;
	private JLabel lblSurname;
	private JLabel lblAge;
	private JLabel lblTelephoneNumber;
	private JLabel lblSex;
	private JLabel lblCity;
	private JButton btnFunnyPhoto;
	
	private Agenda myAddressBook;
	private Contacto myContact;
	
	private AddingWindow addingWindow;
	private EdittingWindow edittingWindow;
	private SearchingWindow searchingWindow;
	private AboutWindow thanksWindow;
	private ControlAccess passwordWindow; 

	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainWindow frame = new MainWindow();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
	
	//Constructor
	public MainWindow() {
		
		super();
							
		initComponents();
		
		//if (!passwordWindow.passwordOk()) System.exit(0); //si se ha fallado 3 veces en el login, salimos app
		
	}
	
	

	//getters y setters de FileToSave, isChanged y textos de los campos
	
	public String getFileToSave() {
		return FileToSave;
	}

	public void setFileToSave(String fileToSave) {
		this.FileToSave = fileToSave;
	}

	
	
	//INICIALIZAR COMPONENTES
	
	

	private void initComponents() {
		
	try {
		
		
		
		myAddressBook = new Agenda();
		myContact = new Contacto();
		
		setTitle("My Address Book ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/imagenes/1f4d2.png")));
		setMinimumSize(new Dimension(500, 650));
		setResizable(false);
		
		//***************************************************************************************
		// BARRA MENÚ OPCIONES 
		//***************************************************************************************
		
		{
			
			MainMenuBar = new JMenuBar();
			MainMenuBar.setBorder(UIManager.getBorder("MenuItem.border"));
			setJMenuBar(MainMenuBar);
			
				mnFile = new JMenu("File");
				mnFile.setMnemonic('O');
				mnFile.setBorderPainted(true);
				mnFile.setPreferredSize(new Dimension(35, 25));
				//mnFile.setActionCommand("");
				MainMenuBar.add(mnFile);
				{
					mnitemFileOpenBook = new JMenuItem("Open Book");
					mnitemFileOpenBook.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							openBook();
						}
					});
					mnitemFileOpenBook.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f4c2.png")));
					mnFile.add(mnitemFileOpenBook);
					
					mnitemFileSaveBook = new JMenuItem("Save Book");
					mnitemFileSaveBook.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							saveBook();
						}
					});
					mnitemFileSaveBook.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f4be.png")));
					mnFile.add(mnitemFileSaveBook);
					
					mnitemFileCloseBook = new JMenuItem("Close Book");
					mnitemFileCloseBook.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							closeBook();
						}

					});
					mnitemFileCloseBook.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f4d4.png")));
					mnFile.add(mnitemFileCloseBook);
					
					JSeparator separator = new JSeparator();
					mnFile.add(separator);
					
					mnitemFileExit = new JMenuItem("Exit");
					mnitemFileExit.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f44b-1f3fc.png")));
					mnFile.add(mnitemFileExit);
					mnitemFileExit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								toExitActionPerformed(evt);
							}

							
						});
				}
				
				
				mnContact = new JMenu("Contact");
				mnContact.setBorderPainted(true);
				mnContact.setPreferredSize(new Dimension(60, 25));
				//mnContact.setActionCommand("");
				MainMenuBar.add(mnContact);
				{
					mnitemContactAddContact = new JMenuItem("Add Contact");
					mnitemContactAddContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							addContact();
						}
					});
					mnitemContactAddContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/add.png")));
					 
					mnContact.add(mnitemContactAddContact);
					
					mnitemContactDeleteContact = new JMenuItem("Delete Contact");
					mnitemContactDeleteContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							deleteContact();
						}
					});
					mnitemContactDeleteContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/del.png")));
					mnContact.add(mnitemContactDeleteContact);
					
					mnitemContactSearchContact = new JMenuItem("Search Contact");
					mnitemContactSearchContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							searchContact();
						}

						
					});
					mnitemContactSearchContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f50e.png")));
					mnContact.add(mnitemContactSearchContact);
					
					mnitemContactEditContact = new JMenuItem("Edit Contact");
					mnitemContactEditContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							editContact();
						}
					});
					mnitemContactEditContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f4dd.png")));
					mnContact.add(mnitemContactEditContact);
				}
				
				mnAppearance = new JMenu("Appearance");
				mnAppearance.setBorderPainted(true);
				mnAppearance.setPreferredSize(new Dimension(90, 25));
				MainMenuBar.add(mnAppearance);
				{
					mnitemAppearanceBackground = new JMenuItem("Background Color");
					mnitemAppearanceBackground.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							changeBackgroundColor();
						}
					});
					mnitemAppearanceBackground.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f58d.png")));
					mnAppearance.add(mnitemAppearanceBackground);
					
					mnitemAppearanceRandomColors = new JMenuItem("Random Colors");
					mnitemAppearanceRandomColors.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
													
							setRandomBackground();
							
						}
					});
					mnitemAppearanceRandomColors.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f3a8.png")));
					mnAppearance.add(mnitemAppearanceRandomColors);
				}
				
				mnAbout = new JMenu("About");
				mnAbout.setPreferredSize(new Dimension(50, 25));
				MainMenuBar.add(mnAbout);
				{
					mnitemHelpAbout = new JMenuItem("About");
					mnitemHelpAbout.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
														
							showAbout();
						}

						
					});
					mnitemHelpAbout.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/2139.png")));
					mnAbout.add(mnitemHelpAbout);
				}				
			
		}
		
		//***************************************************************************************
		// PANEL CONTENEDOR PRINCIPAL
		//***************************************************************************************
		
		{
			ContentPanel = new JPanel();
			getContentPane().add(ContentPanel, BorderLayout.CENTER);
			ContentPanel.setLayout(new BorderLayout(0, 0));
			
			//***************************************************************************************
			// Barra Superior de Botones JTOOLBAR
			//***************************************************************************************
			
				ButtonsToolBar = new JToolBar();
				ButtonsToolBar.setPreferredSize(new Dimension(480, 55));
				ContentPanel.add(ButtonsToolBar, BorderLayout.NORTH);
				
				//***************************************************************************************
				// Botonera de la Barra Superior de Botones JTOOLBAR
				//***************************************************************************************
				
					btnOpenBook = new JButton("");
					btnOpenBook.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							  openBook();
						}
					});
					btnOpenBook.setHorizontalTextPosition(SwingConstants.CENTER);
					
					btnOpenBook.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f4c2.png")));
					btnOpenBook.setMinimumSize(new Dimension(50, 50));
					btnOpenBook.setMaximumSize(new Dimension(50, 50));
					btnOpenBook.setPreferredSize(new Dimension(50, 50));
					btnOpenBook.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f4c2.png")));
					btnOpenBook.setToolTipText("Open Book");
					ButtonsToolBar.add(btnOpenBook);
					getRootPane().setDefaultButton(btnOpenBook);
				
					btnSaveBook = new JButton("");
					btnSaveBook.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							saveBook();
						}
					});
					btnSaveBook.setToolTipText("Save Book");
					btnSaveBook.setMaximumSize(new Dimension(50, 50));
					btnSaveBook.setMinimumSize(new Dimension(50, 50));
					btnSaveBook.setPreferredSize(new Dimension(50, 50));
					btnSaveBook.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f4be.png")));
					btnSaveBook.setHorizontalTextPosition(SwingConstants.CENTER);
					ButtonsToolBar.add(btnSaveBook);
				
					btnCloseBook = new JButton("");
					btnCloseBook.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							closeBook();
						}

						
					});
					btnCloseBook.setToolTipText("Close Book");
					ButtonsToolBar.add(btnCloseBook);
					btnCloseBook.setPreferredSize(new Dimension(50, 50));
					btnCloseBook.setMinimumSize(new Dimension(50, 50));
					btnCloseBook.setMaximumSize(new Dimension(50, 50));
					btnCloseBook.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f4d4.png")));
					btnCloseBook.setHorizontalTextPosition(SwingConstants.CENTER);
				
					btnExit = new JButton("");
					btnExit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							exitApp();
						}
					});
					btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
					btnExit.setToolTipText("Exit");
					btnExit.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f44b-1f3fc.png")));
					btnExit.setMaximumSize(new Dimension(50, 50));
					btnExit.setMinimumSize(new Dimension(50, 50));
					btnExit.setPreferredSize(new Dimension(50, 50));
					ButtonsToolBar.add(btnExit);
				
					btnAddContact = new JButton("");
					btnAddContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							addContact(); 
						}
					});
					
					//Insertar contacto
					btnAddContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/add.png")));
					btnAddContact.setToolTipText("Add Contact");
					btnAddContact.setHorizontalTextPosition(SwingConstants.CENTER);
					btnAddContact.setMaximumSize(new Dimension(50, 50));
					btnAddContact.setMinimumSize(new Dimension(50, 50));
					btnAddContact.setPreferredSize(new Dimension(50, 50));
					
					ButtonsToolBar.add(btnAddContact);
				
					btnDeleteContact = new JButton("");
					btnDeleteContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							deleteContact();
							
						}
				
						
					});
					btnDeleteContact.setHorizontalTextPosition(SwingConstants.CENTER);
					btnDeleteContact.setToolTipText("Delete Contact");
					btnDeleteContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/del.png")));
					btnDeleteContact.setMaximumSize(new Dimension(50, 50));
					btnDeleteContact.setMinimumSize(new Dimension(50, 50));
					btnDeleteContact.setPreferredSize(new Dimension(50, 50));
					ButtonsToolBar.add(btnDeleteContact);
				
					btnEditContact = new JButton("");
					btnEditContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							editContact();
						}

					});
					btnEditContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f4dd.png")));
					btnEditContact.setMinimumSize(new Dimension(50, 50));
					btnEditContact.setMaximumSize(new Dimension(50, 50));
					btnEditContact.setPreferredSize(new Dimension(50, 50));
					btnEditContact.setToolTipText("Edit Contact");
					btnEditContact.setHorizontalTextPosition(SwingConstants.CENTER);
					ButtonsToolBar.add(btnEditContact);
				
					btnSearchContact = new JButton("");
					btnSearchContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							searchContact();
						}
					});
					btnSearchContact.setToolTipText("Search Contact");
					btnSearchContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/1f50e.png")));
					btnSearchContact.setMaximumSize(new Dimension(50, 50));
					btnSearchContact.setMinimumSize(new Dimension(50, 50));
					btnSearchContact.setPreferredSize(new Dimension(50, 50));
					btnSearchContact.setHorizontalTextPosition(SwingConstants.CENTER);
					ButtonsToolBar.add(btnSearchContact);
				
			//***************************************************************************************
			// Panel inferior 
			//***************************************************************************************	
					
				DownPanel = new JPanel();
				DownPanel.setPreferredSize(new Dimension(480, 100));
				ContentPanel.add(DownPanel, BorderLayout.SOUTH);
				DownPanel.setLayout(new BorderLayout(0, 0));
				
				//***************************************************************************************
				// Barra de estado
				//***************************************************************************************
							
				lblStatusBarLabel = new JLabel("");
				lblStatusBarLabel.setHorizontalTextPosition(SwingConstants.CENTER);
				lblStatusBarLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblStatusBarLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				DownPanel.add(lblStatusBarLabel, BorderLayout.SOUTH);
				lblStatusBarLabel.setPreferredSize(new Dimension(480, 40));
				lblStatusBarLabel.setText(getFechaActual());
				
				//***************************************************************************************
				// Panel de Navegación Agenda
				//***************************************************************************************
				
				NavigationPanel = new JPanel();
				NavigationPanel.setPreferredSize(new Dimension(480, 60));
				DownPanel.add(NavigationPanel, BorderLayout.NORTH);
				
					btnPreviousContact = new JButton("");
					btnPreviousContact.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/2b05.png")));
					btnPreviousContact.setBounds(0, 0, 97, 60);
					btnPreviousContact.setMnemonic('P');
					btnPreviousContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							goBackOnePositionInContacts();
						}
					});
					NavigationPanel.setLayout(null);
					btnPreviousContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/2b05.png")));
					btnPreviousContact.setHorizontalTextPosition(SwingConstants.CENTER);
					NavigationPanel.add(btnPreviousContact);
					btnPreviousContact.setPreferredSize(new Dimension(97, 50));
					btnPreviousContact.setMaximumSize(new Dimension(97, 55));
					btnPreviousContact.setAlignmentX(Component.RIGHT_ALIGNMENT);
					btnPreviousContact.setToolTipText("Previous Contact");
					
					btnNextContact = new JButton("");
					btnNextContact.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/27a1.png")));
					btnNextContact.setBounds(397, 0, 97, 60);
					btnNextContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							advanceOnePositionInContacts();
						}

						
					});
					btnNextContact.setPreferredSize(new Dimension(97, 50));
					btnNextContact.setHorizontalTextPosition(SwingConstants.CENTER);
					btnNextContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/27a1.png")));
					NavigationPanel.add(btnNextContact);
					btnNextContact.setMaximumSize(new Dimension(97, 55));
					btnNextContact.setToolTipText("Next Contact");
				
					lblContactPosition = new JLabel("");
					lblContactPosition.setBounds(144, 0, 201, 60);
					lblContactPosition.setHorizontalTextPosition(SwingConstants.CENTER);
					lblContactPosition.setHorizontalAlignment(SwingConstants.CENTER);
					NavigationPanel.add(lblContactPosition);
					
					btnFirstContact = new JButton("");
					btnFirstContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							
							showFirstContact();
						}
					
					});
					btnFirstContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/23ea.png")));
					btnFirstContact.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/23ea.png")));
					btnFirstContact.setToolTipText("FirstContact");
					btnFirstContact.setPreferredSize(new Dimension(97, 50));
					btnFirstContact.setMnemonic('P');
					btnFirstContact.setMaximumSize(new Dimension(97, 50));
					btnFirstContact.setHorizontalTextPosition(SwingConstants.CENTER);
					btnFirstContact.setEnabled(false);
					btnFirstContact.setAlignmentX(1.0f);
					btnFirstContact.setBounds(97, 0, 50, 60);
					NavigationPanel.add(btnFirstContact);
					
					btnLastContact = new JButton("");
					btnLastContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							showLastContact();
						}
					});
					btnLastContact.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/23e9.png")));
					btnLastContact.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/23e9.png")));
					btnLastContact.setToolTipText("Last Contact");
					btnLastContact.setPreferredSize(new Dimension(97, 50));
					btnLastContact.setMnemonic('P');
					btnLastContact.setMaximumSize(new Dimension(97, 50));
					btnLastContact.setHorizontalTextPosition(SwingConstants.CENTER);
					btnLastContact.setEnabled(false);
					btnLastContact.setAlignmentX(1.0f);
					btnLastContact.setBounds(347, 0, 50, 60);
					NavigationPanel.add(btnLastContact);
				
			//***************************************************************************************
			// PANEL CENTRAL VISTA DATOS CONTACTOS
			//***************************************************************************************
					
				CentralContactPanel = new JPanel();
				ContentPanel.add(CentralContactPanel, BorderLayout.CENTER);
				CentralContactPanel.setLayout(null);
				
				lblName = new JLabel("Name");
				lblName.setBounds(75, 142, 80, 30);
				CentralContactPanel.add(lblName);
				
				textField_NAME = new JTextField();
				textField_NAME.setBackground(Color.WHITE);
				textField_NAME.setEditable(false);
				textField_NAME.setBounds(150, 142, 250, 30);
				textField_NAME.setAlignmentX(Component.RIGHT_ALIGNMENT);
				textField_NAME.setHorizontalAlignment(SwingConstants.RIGHT);
				CentralContactPanel.add(textField_NAME);
				textField_NAME.setColumns(10);
				
				
				lblSurname = new JLabel("Surname");
				lblSurname.setBounds(75, 185, 80, 30);
				CentralContactPanel.add(lblSurname);
				
				textField_SURNAME = new JTextField();
				textField_SURNAME.setBackground(Color.WHITE);
				textField_SURNAME.setEditable(false);
				textField_SURNAME.setHorizontalAlignment(SwingConstants.RIGHT);
				textField_SURNAME.setColumns(10);
				textField_SURNAME.setAlignmentX(1.0f);
				textField_SURNAME.setBounds(150, 185, 250, 30);
				CentralContactPanel.add(textField_SURNAME);
				
				lblAge = new JLabel("Age");
				lblAge.setBounds(75, 241, 50, 30);
				CentralContactPanel.add(lblAge);
				
				textField_AGE = new JTextField();
				textField_AGE.setBackground(Color.WHITE);
				textField_AGE.setEditable(false);
				textField_AGE.setHorizontalAlignment(SwingConstants.RIGHT);
				textField_AGE.setColumns(10);
				textField_AGE.setAlignmentX(1.0f);
				textField_AGE.setBounds(115, 241, 50, 30);
				CentralContactPanel.add(textField_AGE);
				
				lblTelephoneNumber = new JLabel("Phone Number");
				lblTelephoneNumber.setBounds(75, 284, 90, 30);
				CentralContactPanel.add(lblTelephoneNumber);
				
				textField_PHONE = new JTextField();
				textField_PHONE.setBackground(Color.WHITE);
				textField_PHONE.setEditable(false);
				textField_PHONE.setHorizontalAlignment(SwingConstants.RIGHT);
				textField_PHONE.setColumns(10);
				textField_PHONE.setAlignmentX(1.0f);
				textField_PHONE.setBounds(185, 284, 200, 30);
				CentralContactPanel.add(textField_PHONE);
				
				
				
				//FOTOGRAFÍA ALEATORIA DE PRUEBA
				
				btnFunnyPhoto = new JButton("FunnyPhoto");
				btnFunnyPhoto.setBackground(new Color(153, 153, 204));
				btnFunnyPhoto.setBounds(370, 13, 100, 100);
				CentralContactPanel.add(btnFunnyPhoto);
				
				lblSex = new JLabel("Sex");
				lblSex.setBounds(207, 241, 50, 30);
				CentralContactPanel.add(lblSex);
				
				textField_SEX = new JTextField();
				textField_SEX.setBackground(Color.WHITE);
				textField_SEX.setEditable(false);
				textField_SEX.setHorizontalAlignment(SwingConstants.RIGHT);
				textField_SEX.setColumns(10);
				textField_SEX.setAlignmentX(1.0f);
				textField_SEX.setBounds(249, 241, 50, 30);
				CentralContactPanel.add(textField_SEX);
				
				lblCity = new JLabel("City");
				lblCity.setBounds(75, 327, 90, 30);
				CentralContactPanel.add(lblCity);
				
				textField_CITY = new JTextField();
				textField_CITY.setBackground(Color.WHITE);
				textField_CITY.setHorizontalAlignment(SwingConstants.RIGHT);
				textField_CITY.setEditable(false);
				textField_CITY.setColumns(10);
				textField_CITY.setAlignmentX(1.0f);
				textField_CITY.setBounds(130, 327, 200, 30);
				CentralContactPanel.add(textField_CITY);
				
				
		}
		
		//visualizar la caja diálogo del control de acceso
		
		//Ventana control acceso modal
		this.passwordWindow = new ControlAccess(this, true);	
		this.passwordWindow.setVisible(true);
		
	}catch (Exception ex){
		//TODO implementar acciones en caso excepciones
		System.err.println("EXCEPCIONES SIN CONTROLAR EN INITCOMPONENTS()");
		ex.printStackTrace();
	}
		
		
		
		
		pack();
		this.setSize(500, 650);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				windowClosingPerformed(e);				
			}

			
		});
		
		
		
		this.enableButtonsItemsMenu(false);  //aqui esta la habilitación botones
		
	}
	
	
	//***************************************************************************************
	// Acciones de los items del menú
	//***************************************************************************************
	
	

	private void toExitActionPerformed(ActionEvent evt) {
		this.exitApp();
		
	}
	
	private void showAbout() {
		this.thanksWindow = new AboutWindow();
		this.thanksWindow.setVisible(true);
		this.thanksWindow.setTitle("About");
		
	}

	//***************************************************************************************
	// Acciones de los botones de la ventana maxim-minim-close
	//***************************************************************************************
	private void windowClosingPerformed(java.awt.event.WindowEvent e) {

		this.exitApp();	
	}
	
	
	//***************************************************************************************
	// Método para habilitar botones e items menú 
	//***************************************************************************************
	
	private void enableButtonsItemsMenu(boolean flag){
		
		this.btnAddContact.setEnabled(flag);
		this.btnDeleteContact.setEnabled(flag);
		this.btnEditContact.setEnabled(flag);
		this.btnSearchContact.setEnabled(flag);
		this.btnCloseBook.setEnabled(flag);
		this.btnSaveBook.setEnabled(flag);
		this.mnitemContactAddContact.setEnabled(flag);
		this.mnitemContactDeleteContact.setEnabled(flag);
		this.mnitemContactEditContact.setEnabled(flag);
		this.mnitemContactSearchContact.setEnabled(flag);
		this.mnitemFileCloseBook.setEnabled(flag);
		this.mnitemFileSaveBook.setEnabled(flag);
		this.btnNextContact.setEnabled(flag);
		this.btnPreviousContact.setEnabled(flag);
		this.btnLastContact.setEnabled(flag);
		this.btnFirstContact.setEnabled(flag);
		this.lblContactPosition.setEnabled(flag);
	}
	
private void enablePartialButtonsItemsMenu(boolean flag){
		
		this.btnAddContact.setEnabled(flag);
		
		this.btnCloseBook.setEnabled(flag);
		this.btnSaveBook.setEnabled(flag);
		this.mnitemContactAddContact.setEnabled(flag);
		
		this.mnitemFileCloseBook.setEnabled(flag);
		this.mnitemFileSaveBook.setEnabled(flag);
		this.btnNextContact.setEnabled(flag);
		this.btnPreviousContact.setEnabled(flag);
		this.btnLastContact.setEnabled(flag);
		this.btnFirstContact.setEnabled(flag);
		this.lblContactPosition.setEnabled(flag);
	}
	
	
//***************************************************************************************
//Métodos que implementan las acciones de los botones y los items del menú (Salida etc.) 
//***************************************************************************************
	
	private void changeBackgroundColor(){
		
		Color color = JColorChooser.showDialog(null, "Select your favourite color!", CentralContactPanel.getBackground());
        
		CentralContactPanel.setBackground(color);
       		
	}
	
	private void setRandomBackground(){
		
		float red = (float) Math.random();
		float green = (float) Math.random();
		float blue = (float) Math.random();
		CentralContactPanel.setBackground(new Color(red,green,blue));
	}
	
	private void openBook(){
		//si existe una ruta de fichero válida almacenada, hay una agenda previa abierta
		if(myAddressBook.getIsChanged() && !FileToSave.isEmpty()){  //&& FileToSave.contains(".txt")
			Object [] options2 = {"Save","Don´t Save","Cancel"};
			int resp = JOptionPane.showOptionDialog (null, "Save changes before opening a new Address Book?", 
					"Warning", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,null,options2,options2[0]);
			
			if (resp==JOptionPane.YES_OPTION){
				//Guardar Agenda y limpiar campos
				this.saveBook(); //incluye poner a 0 la posición del contacto actual
				this.cleanFields();
				//inhabilitar las funciones de buscar/editar/insertar hasta abrir otro libro
				this.enableButtonsItemsMenu(false);
			}				
			else{
				if (resp==JOptionPane.NO_OPTION){
					//Si está seguro de NO querer guardar los cambios, salir directamente sin guardar
					this.cleanFields();
					myAddressBook.setIsChanged(false);
					myAddressBook.setNowContact(0); //poner a 0 la posición del contacto actual
					this.editStatusBar("Your Address Book is correctly CLOSED");
					//inhabilitar las funciones de buscar/editar/insertar hasta abrir otro libro
					this.enableButtonsItemsMenu(false);
				}
				else{
					//Si se CANCELA, no hacer nada				
				}	
			}
		}
		
		try{
		//Seleccionar el fichero que queremos abrir
		JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int option = fc.showOpenDialog(this);
		//si seleccionamos un fichero y pulsamos la opción de abrir
		if(option == JFileChooser.APPROVE_OPTION) {
		//se toma la ruta del fichero para el I/O
			setFileToSave(fc.getSelectedFile().getAbsolutePath());
					

			//Cargar listado Contactos y mostrar el primero en la interfaz (ahora nowContact = 0)
			myAddressBook.cargarFichero(fc.getSelectedFile().getAbsolutePath());
			//poner el nombre del archivo cargado en el título:
			
			setTitle("Current Address Book: " + fc.getSelectedFile().getName());
			
			//Si el vector de contactos estuviera vacío
			if(myAddressBook.getListaContactos().isEmpty()){
				//avisar al usuario de que su agenda está vacía
				JOptionPane.showMessageDialog(null, "Empty AddressBook loaded!","Warning",JOptionPane.WARNING_MESSAGE);
				editStatusBar("Loaded Book is EMPTY!");
				cleanFields();
				enablePartialButtonsItemsMenu(true); //habilitado parcial

			}else{
				//si no, indicar que la carga es correcta
				editStatusBar("The chosen Book is correctly LOADED");
				myAddressBook.setNowContact(0); //Inicializar a cero el localizador de posición
				this.showContact(myAddressBook.getListaContactos(),myAddressBook.getNowContact());
				showPositionsInLabel(myAddressBook.getNowContact(), myAddressBook.getListaContactos().size());
				//habilitar las funciones de buscar/editar/insertar
				this.enableButtonsItemsMenu(true);
			}
		
		}else if (option == JFileChooser.CANCEL_OPTION){
			//si Cancela asegurar que los botones están inhabilitados
			this.enableButtonsItemsMenu(false);
			
		}
				
		
		
		}
		catch (InputMismatchException e) {
			
			editStatusBar("The selected file is not an Address Book");
			
			JOptionPane.showMessageDialog(null, "The selected file is not an Address Book","Error",JOptionPane.ERROR_MESSAGE);
			
		}
		catch (NoSuchElementException e) {
			
			editStatusBar("Please, select an Address Book");
			
			JOptionPane.showMessageDialog(null, "Please, select an AddressBook","Warning",JOptionPane.WARNING_MESSAGE);
			
		}
		catch (NullPointerException e) {
			
			editStatusBar("The element being requested does not exist");
			
			JOptionPane.showMessageDialog(null, "The element being requested does not exist","Error",JOptionPane.ERROR_MESSAGE);	
		}
		
		
	}
	
//Método para mostrar el contacto que está en una posición concreta
	
	public void showContact(Vector<Contacto> c, int index){
		
		textField_NAME.setText(c.elementAt(index).getNombre());
		textField_SURNAME.setText(c.elementAt(index).getApellidos());
		textField_AGE.setText( Integer.toString( c.elementAt(index).getEdad() ) );
		textField_SEX.setText(c.elementAt(index).getSexo());
		textField_PHONE.setText(c.elementAt(index).getTelefono());
		textField_CITY.setText(c.elementAt(index).getCiudad());
		
		showPositionsInLabel(index, c.size());
		
		//mostrar foto aleatoria
		this.btnFunnyPhoto.setText("");
		int ini=1;
		int fin=43;
		int idIcon = (int) (Math.random()*(fin-ini+1) + ini);
		this.btnFunnyPhoto.setIcon(new ImageIcon(MainWindow.class.getResource("/imagenes/"+idIcon+".png")));
		
		
	}
	
	//***************************************************************************************
	// MÉTODOS DE LA BARRA DE NAVEGACIÓN CONTACTOS
	//***************************************************************************************
	
	private void advanceOnePositionInContacts() {
			
		try {
			//si la posición actual es igual a la última, no avanzo
			if(myAddressBook.getNowContact() == myAddressBook.getListaContactos().size()-1 || myAddressBook.getListaContactos().isEmpty()){
				btnNextContact.setEnabled(false);
				
			}else{
				btnNextContact.setEnabled(true);
				btnPreviousContact.setEnabled(true);
				//aumento nowContact en 1
				int position = myAddressBook.getNowContact()+1;
				myAddressBook.setNowContact(position);
				//muestro el contacto de la posición actual incrementada en 1 
				this.showContact(myAddressBook.getListaContactos(), position);
				
				
			}
			this.cleanStatusBar();
			
			
			
		} catch (NoSuchElementException e) {
			
			JOptionPane.showMessageDialog(null, "Empty AddressBook!","Warning",JOptionPane.WARNING_MESSAGE);
			cleanPositionsInLabel();
		}
		
				
	}
	
	private void goBackOnePositionInContacts(){
		
		try {
			
			//si la posición actual es igual a la primera, no retrocedo
			if(myAddressBook.getNowContact() == 0 || myAddressBook.getListaContactos().isEmpty()){
				btnPreviousContact.setEnabled(false);
				
			}else{
				btnPreviousContact.setEnabled(true);
				btnNextContact.setEnabled(true);
				//aumento nowContact en 1
				int position = myAddressBook.getNowContact()-1;
				myAddressBook.setNowContact(position);
				//muestro el contacto de la posición actual decrementada en 1 
				this.showContact(myAddressBook.getListaContactos(), position);
				
			}
			
			this.cleanStatusBar();
			
		} catch (NoSuchElementException e) {
			JOptionPane.showMessageDialog(null, "Empty AddressBook!","Warning",JOptionPane.WARNING_MESSAGE);
			cleanPositionsInLabel();
		}
		
		
	}
	
	
	private void showFirstContact() {
		
		
			try{
				btnPreviousContact.setEnabled(false);
				btnNextContact.setEnabled(true);
							
				textField_NAME.setText(myAddressBook.getListaContactos().firstElement().getNombre());
				textField_SURNAME.setText(myAddressBook.getListaContactos().firstElement().getApellidos());
				textField_AGE.setText(Integer.toString(myAddressBook.getListaContactos().firstElement().getEdad()));
				textField_SEX.setText(myAddressBook.getListaContactos().firstElement().getSexo());
				textField_PHONE.setText(myAddressBook.getListaContactos().firstElement().getTelefono());
				textField_CITY.setText(myAddressBook.getListaContactos().firstElement().getCiudad());
				
				int param1 = myAddressBook.getListaContactos().size();
				myAddressBook.setNowContact(0);
				showPositionsInLabel(myAddressBook.getNowContact(),param1);
				
				editStatusBar("First Contact in your list");
			}
			catch (NoSuchElementException e) {
				
				JOptionPane.showMessageDialog(null, "Empty AddressBook!","Warning",JOptionPane.WARNING_MESSAGE);
				cleanPositionsInLabel();
			}
			
			
		
		
	}
	
	private void showLastContact(){
		
		try {
			
			btnNextContact.setEnabled(false);
			btnPreviousContact.setEnabled(true);
			
			textField_NAME.setText(myAddressBook.getListaContactos().lastElement().getNombre());
			textField_SURNAME.setText(myAddressBook.getListaContactos().lastElement().getApellidos());
			textField_AGE.setText(Integer.toString(myAddressBook.getListaContactos().lastElement().getEdad()));
			textField_SEX.setText(myAddressBook.getListaContactos().lastElement().getSexo());
			textField_PHONE.setText(myAddressBook.getListaContactos().lastElement().getTelefono());
			textField_CITY.setText(myAddressBook.getListaContactos().lastElement().getCiudad());
			
			int param1 = myAddressBook.getListaContactos().size();
			myAddressBook.setNowContact(param1-1); //posición real del elemento
			showPositionsInLabel(param1-1,param1);
			editStatusBar("Last Contact in your list");
			
		} catch (NoSuchElementException e) {
			
			JOptionPane.showMessageDialog(null, "Empty AddressBook!","Warning",JOptionPane.WARNING_MESSAGE);
			cleanPositionsInLabel();
		}
		
	}
	
	private void showPositionsInLabel(int position, int vectorSize){
		
		lblContactPosition.setText((position+1) +" of "+ myAddressBook.getListaContactos().size());
		
	}
	
	
	
	//***************************************************************************************
	// MÉTODOS GESTIÓN DE CONTACTOS
	//***************************************************************************************
	
	private void addContact() {
		// abrimos ventana adicional para insertar contactos
		this.addingWindow = new AddingWindow(this,myAddressBook);
		this.addingWindow.setVisible(true);
		this.addingWindow.setTitle("Add Contact");
		myAddressBook.setIsChanged(true);
		this.setVisible(false);
	}
	
	private void editContact() {
		//abrimos la ventana auxiliar y cerramos la vista de la principal
		this.edittingWindow = new EdittingWindow(this,myAddressBook);
		this.edittingWindow.setVisible(true);
		this.edittingWindow.setTitle("Edit Contact");
		myAddressBook.setIsChanged(true);
		this.setVisible(false);
	}
	
	
	private void deleteContact() {  
		
		//mostrar al inicio el diálogo para borrar el contacto con confirmación
		Object [] options = {"Yes","No","Cancel"};
		int resp = 1;
		
		resp = JOptionPane.showOptionDialog(null, "This contact will be removed: Are you sure?",
				"Warning!",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[1]);
		
		if(resp == JOptionPane.YES_OPTION){
			//detecta la posición del contacto visualizado en agenda
			int index = myAddressBook.getNowContact();
			//borra el contacto en esta posición (reduce tamaño vector en 1)
			myAddressBook.eliminarContacto(index);
			//informa al usuario
			editStatusBar("Contact was REMOVED Successfully!");
			//limpia campos del contacto borrado
			cleanFields();
			//hay cambios en agenda
			myAddressBook.setIsChanged(true);
			//muestra el primer contacto y actualiza la información de posición/número total Contactos
			this.showFirstContact();

		}else if (resp == JOptionPane.NO_OPTION){

			editStatusBar("Contact remains in your Address Book!");


		}else{

			//si se CANCELA no hacer nada

		}
		//si tras el borrado la lista está vacía, inhabilitar el botón y el menu
		//(cuando se cargue otra agenda, se habilitarán)
		if(myAddressBook.getListaContactos().isEmpty()){
			editStatusBar("Your Address Book is EMPTY!");
			btnDeleteContact.setEnabled(false);
			mnitemContactDeleteContact.setEnabled(false);
		}
		
	}

	

	private void searchContact() {
		
		this.searchingWindow = new SearchingWindow(this,myAddressBook);
		this.searchingWindow.setVisible(true);
		this.searchingWindow.setTitle("Search Contact");
		myAddressBook.setIsChanged(true);
		this.setVisible(false);
	}
	
//***************************************************************************************
// Métodos Botones ventana / guardar y cerrar Agenda
//***************************************************************************************	
	
	
	private void closeBook() {  
				
		//si no se detectan cambios pendientes de guardar en la agenda
		if(!myAddressBook.getIsChanged()){
			
			Object [] options = {"Yes", "Cancel"};
			int resp;
			
			resp = JOptionPane.showOptionDialog(null, "The Address Book will be closed: Are you sure?", 
					"Close Address Book", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
			
			if (resp==JOptionPane.OK_OPTION){
				this.cleanFields();
				myAddressBook.setNowContact(0); //poner a 0 la posición del contacto actual
				this.editStatusBar("Your Address Book is correctly CLOSED");
								
			}else{
				//si se CANCELA, no hacer nada
			}
			
		}else{
			//...preguntar si se quiere cerrar sin guardar
			Object [] options2 = {"Yes","Save","Cancel"};
			int resp = JOptionPane.showOptionDialog (null, "Are you sure you want to close without save changes?", 
					"Warning", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,null,options2,options2[0]);
			
			if (resp==JOptionPane.NO_OPTION){
				//Guardar Agenda y limpiar campos
				this.saveBook(); //incluye poner a 0 la posición del contacto actual
				this.cleanFields();
				
			}				
			else{
				if (resp==JOptionPane.YES_OPTION){
					//Si está seguro de NO querer guardar los cambios, salir directamente sin guardar
					this.cleanFields();
					myAddressBook.setIsChanged(false);
					myAddressBook.setNowContact(0); //poner a 0 la posición del contacto actual
					this.editStatusBar("Your Address Book is correctly CLOSED");
				}
				else{
					//Si se CANCELA, no hacer nada				
				}	
			}
		
		}
		
		enableButtonsItemsMenu(false); //hasta que no se abra otra agenda no se habilitarían los botones
		this.FileToSave = ""; //vaciar la ruta del fichero, si se abre otra agenda 
								//podemos detectar si hay otra en uso o no
		setTitle("My Address Book");
	}
	
	
	private void saveBook() {
		
		
		//Guardar fichero e informar al usuario	
		myAddressBook.guardarFichero();
		//indicar que no hay cambios
		myAddressBook.setIsChanged(false);
		
		this.editStatusBar("Your Address Book is correctly saved!");
		
		
	}
	
	
	private void exitApp(){
				
		//Si no hubo cambios registrados en Agenda
		if (!myAddressBook.getIsChanged()){
			//preguntar si se desea salir
			Object [] option = {"Yes","Cancel"};
			int resp = JOptionPane.showOptionDialog (null, "Exit: Are you sure?", "Exit", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,option, option[1]);
			if (resp==JOptionPane.OK_OPTION){
				this.FileToSave = ""; //vaciar la ruta del fichero, si se abre otra agenda 
				//podemos detectar si hay otra en uso o no
				//y salir de la app
				System.exit(0);
			}else{
				
				//si CANCELA no hacer nada
			}
					
		}else{ //Si ha habido cambios en la lista de Contactos...
			//...preguntar si se quiere guardar
			Object [] option2 = {"Save", "Don´t save","Cancel"};
			int resp = JOptionPane.showOptionDialog (null, "Do you want to save the changes before exit?", "Warning", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,null, option2,option2[0]);
			
			if (resp==JOptionPane.YES_OPTION){
				//Guardar Agenda
				this.saveBook();
				
				this.FileToSave = ""; //vaciar la ruta del fichero, si se abre otra agenda 
				//podemos detectar si hay otra en uso o no
				//y salir de app
				System.exit(0);
			}				
			else if(resp==JOptionPane.NO_OPTION){
				this.FileToSave = ""; //vaciar la ruta del fichero, si se abre otra agenda 
				//podemos detectar si hay otra en uso o no
				//salir sin guardar
				System.exit(0);
				}
				else{
				//Si se CANCELA no hacer nada
					
				}
			}
				
		}
		
	//***************************************************************************************
	// Seguridad--> Con JOptionPane  : inputDialog y messageDialog
	//***************************************************************************************	
	
	 boolean passwordOk() {  
		
		int nCuenta = 0;
		
		String palabraDePaso = null;
		//se admiten 3 intentos
		
		do{
					
			//coger la contraseña introducida
			
			palabraDePaso = JOptionPane.showInputDialog(null, "Password: ");
			
			//compararla con la contraseña
			if(palabraDePaso != null && palabraDePaso.compareTo("pyrena") !=0){
				
				nCuenta++;
				JOptionPane.showMessageDialog(null, "Wrong password", "Error", JOptionPane.ERROR_MESSAGE);
				
			}else{
				
				nCuenta=4;
			}
			
		}while(nCuenta<3);
		
		if(palabraDePaso == null || nCuenta == 3) return false;//saldremos de la aplicación
			
		else return true;
		
		
		 
	}	
	
	
	
//***************************************************************************************
// Otros métodos 
//***************************************************************************************
	public void cleanPositionsInLabel(){
		lblContactPosition.setText("Click on arrows");
	}
	private void cleanFields() {

		textField_NAME.setText("");
		textField_SURNAME.setText("");
		textField_AGE.setText("");
		textField_SEX.setText("");
		textField_PHONE.setText("");
		textField_CITY.setText("");
		this.cleanPositionsInLabel();
	}
		
	public void cleanStatusBar(){
			
			editStatusBar("");
		}
	
	public void editStatusBar(String msg){
			//Modificar barra de notificaciones
			lblStatusBarLabel.setText(getFechaActual() + "  >>>  " + msg + "  at  " + getHoraActual());	
			
		}
	
	public void updateListPosition(){
		//si la lista tiene algún contacto..
		if(!myAddressBook.getListaContactos().isEmpty()){
			//..y se actualizan las posiciones
			lblStatusBarLabel.setText((myAddressBook.getNowContact() + 1) + " de " + myAddressBook.getListaContactos().size());
		}
		else{
			this.cleanPositionsInLabel();
		}
	}	
		
	//Método usado para obtener la fecha actual del sistema
	private String getFechaActual() {
	        Date ahora = new Date();
	        SimpleDateFormat formateador = new SimpleDateFormat("yyyy '-' MM '-' dd ");
	        return formateador.format(ahora);
	    }

	//Método usado para obtener la hora actual del sistema (se ha eliminado el modificador static)
	private String getHoraActual() {
	        Date ahora = new Date();
	        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm");
	        return formateador.format(ahora);
	    }	
} //class

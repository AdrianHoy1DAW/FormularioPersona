package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import net.miginfocom.swing.MigLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;

public class VistaFormulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldName;
	private JTextField txtFieldSurname;
	private JTextField txtFieldAddress;
	private JTextField txtFieldDni;
	private JTextField txtFieldPhone;
	private DefaultComboBoxModel<String> dcm;
	private DefaultComboBoxModel<Integer> dim;
	private JComboBox<String> comboBoxCity;
	private JRadioButton rdbtnWomen;
	private JRadioButton rdbtnMen;
	private JComboBox<Integer> comboBoxAge;
	private JButton btnAdd;
	private JButton btnNew;
	private JButton btnNext;
	private JButton btnPrevious;
	private JPanel panelDatos;
	


	/**
	 * Create the frame.
	 */
	public VistaFormulario() {
		
		String[] city = new String[] {"Madrid","Almería","Cádiz","Córdoba","Granada","Huelva","Jaén","Málaga","Sevilla","Huesca","Teruel","Zaragoza","Asturias","Baleares","LasPalmas","SantaCruzdeTenerife","Cantabria","Albacete","CiudadReal","Cuenca","Guadalajara","Toledo","Ávila","Burgos","León","Palencia","Salamanca","Segovia","Soria","Valladolid","Zamora","Barcelona","Gerona","Lérida","Tarragona","Alicante","Castellón","Valencia","Badajoz","Cáceres","LaCoruña","Lugo","Orense","Pontevedra","LaRioja","RegióndeMurcia","Navarra","Álava","Guipúzcoa","Vizcaya"};
		Vector<String> vCity = new Vector<String>();
		for(String c :city) {
			vCity.add(c);
		}
		vCity.sort((c1,c2)->c1.compareTo(c2));
		
		Integer[] numeros = new Integer[100];
		for(int i = 0; i < numeros.length;i++) {
			numeros[i] = i + 1;
		}
		
		dim = new DefaultComboBoxModel<Integer>(numeros);
		dcm = new DefaultComboBoxModel<String>(vCity);
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("FIle");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmExit = new JMenuItem("Open");
		mnNewMenu.add(mntmExit);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setEnabled(false);
		mnNewMenu.add(mntmSave);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmOpen = new JMenuItem("Exit");
		mnNewMenu.add(mntmOpen);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelDatos = new JPanel();
		
		JPanel panelBotones = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelDatos, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelDatos, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GroupLayout gl_panelBotones = new GroupLayout(panelBotones);
		gl_panelBotones.setHorizontalGroup(
			gl_panelBotones.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelBotones.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelBotones.setVerticalGroup(
			gl_panelBotones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addGroup(gl_panelBotones.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		panel_1.add(btnAdd);
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		btnPrevious = new JButton("<");
		btnPrevious.setEnabled(false);
		panel.add(btnPrevious);
		
		btnNext = new JButton(">");
		btnNext.setEnabled(false);
		panel.add(btnNext);
		
		btnNew = new JButton("New");
		panel.add(btnNew);
		panelBotones.setLayout(gl_panelBotones);
		panelDatos.setLayout(new MigLayout("", "[86.00][169.00,grow][][]", "[20.00][23.00][24.00][26.00][28.00][25.00][28.00]"));
		
		JLabel lblName = new JLabel("Name");
		panelDatos.add(lblName, "cell 0 1");
		
		txtFieldName = new JTextField();
		txtFieldName.setEnabled(false);
		panelDatos.add(txtFieldName, "cell 1 1 3 1,growx");
		txtFieldName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		panelDatos.add(lblSurname, "cell 0 2");
		
		txtFieldSurname = new JTextField();
		txtFieldSurname.setEnabled(false);
		panelDatos.add(txtFieldSurname, "cell 1 2 3 1,growx");
		txtFieldSurname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		panelDatos.add(lblAddress, "cell 0 3");
		
		txtFieldAddress = new JTextField();
		txtFieldAddress.setEnabled(false);
		panelDatos.add(txtFieldAddress, "cell 1 3 3 1,growx");
		txtFieldAddress.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		panelDatos.add(lblCity, "cell 0 4");
		
		comboBoxCity = new JComboBox<String>();
		comboBoxCity.setEnabled(false);
		comboBoxCity.setModel(dcm);
		panelDatos.add(comboBoxCity, "cell 1 4,growx");
		
		JLabel lblDni = new JLabel("DNI");
		panelDatos.add(lblDni, "cell 0 5");
		
		txtFieldDni = new JTextField();
		txtFieldDni.setEnabled(false);
		panelDatos.add(txtFieldDni, "cell 1 5,growx");
		txtFieldDni.setColumns(10);
		
		JLabel lblYears = new JLabel("Years");
		panelDatos.add(lblYears, "cell 2 5,alignx trailing");
		
		comboBoxAge = new JComboBox<Integer>();
		comboBoxAge.setEnabled(false);
		comboBoxAge.setModel(dim);
		panelDatos.add(comboBoxAge, "cell 3 5,growx");
		
		JLabel lblPhone = new JLabel("Phone");
		panelDatos.add(lblPhone, "cell 0 6");
		
		txtFieldPhone = new JTextField();
		txtFieldPhone.setEnabled(false);
		panelDatos.add(txtFieldPhone, "cell 1 6,growx");
		txtFieldPhone.setColumns(10);
		
		ButtonGroup bg = new ButtonGroup();
		
		rdbtnMen = new JRadioButton("Men");
		rdbtnMen.setEnabled(false);
		panelDatos.add(rdbtnMen, "cell 2 6");
		
		rdbtnWomen = new JRadioButton("Women");
		rdbtnWomen.setEnabled(false);
		panelDatos.add(rdbtnWomen, "cell 3 6");
		contentPane.setLayout(gl_contentPane);
		
		bg.add(rdbtnWomen);
		bg.add(rdbtnMen);
		
		rdbtnMen.setSelected(true);
		
		
	}



	public JTextField getTxtFieldName() {
		return txtFieldName;
	}



	public void setTxtFieldName(JTextField txtFieldName) {
		this.txtFieldName = txtFieldName;
	}



	public JTextField getTxtFieldSurname() {
		return txtFieldSurname;
	}



	public void setTxtFieldSurname(JTextField txtFieldSurname) {
		this.txtFieldSurname = txtFieldSurname;
	}



	public JTextField getTxtFieldAddress() {
		return txtFieldAddress;
	}



	public void setTxtFieldAddress(JTextField txtFieldAddress) {
		this.txtFieldAddress = txtFieldAddress;
	}



	public JTextField getTxtFieldDni() {
		return txtFieldDni;
	}



	public void setTxtFieldDni(JTextField txtFieldDni) {
		this.txtFieldDni = txtFieldDni;
	}



	public JTextField getTxtFieldPhone() {
		return txtFieldPhone;
	}



	public void setTxtFieldPhone(JTextField txtFieldPhone) {
		this.txtFieldPhone = txtFieldPhone;
	}



	public DefaultComboBoxModel<String> getDcm() {
		return dcm;
	}



	public void setDcm(DefaultComboBoxModel<String> dcm) {
		this.dcm = dcm;
	}



	public DefaultComboBoxModel<Integer> getDim() {
		return dim;
	}



	public void setDim(DefaultComboBoxModel<Integer> dim) {
		this.dim = dim;
	}



	public JComboBox<String> getComboBoxCity() {
		return comboBoxCity;
	}



	public void setComboBoxCity(JComboBox<String> comboBoxCity) {
		this.comboBoxCity = comboBoxCity;
	}



	public JRadioButton getRdbtnWomen() {
		return rdbtnWomen;
	}



	public void setRdbtnWomen(JRadioButton rdbtnWomen) {
		this.rdbtnWomen = rdbtnWomen;
	}



	public JRadioButton getRdbtnMen() {
		return rdbtnMen;
	}



	public void setRdbtnMen(JRadioButton rdbtnMen) {
		this.rdbtnMen = rdbtnMen;
	}



	public JComboBox<Integer> getComboBoxAge() {
		return comboBoxAge;
	}



	public void setComboBoxAge(JComboBox<Integer> comboBoxAge) {
		this.comboBoxAge = comboBoxAge;
	}



	public JButton getBtnAdd() {
		return btnAdd;
	}



	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}



	public JButton getBtnNew() {
		return btnNew;
	}



	public void setBtnNew(JButton btnNew) {
		this.btnNew = btnNew;
	}



	public JButton getBtnNext() {
		return btnNext;
	}



	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}



	public JButton getBtnPrevious() {
		return btnPrevious;
	}



	public void setBtnPrevious(JButton btnPrevious) {
		this.btnPrevious = btnPrevious;
	}



	public JPanel getPanelDatos() {
		return panelDatos;
	}



	public void setPanelDatos(JPanel panelDatos) {
		this.panelDatos = panelDatos;
	}

	


}

package es.ieslavereda.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import modelo.Persona;
import vistas.VistaFormulario;

public class Controlador implements ActionListener{

	private VistaFormulario vista;
	private ArrayList<Persona> personas = new ArrayList<>();
	private int indice;

	public Controlador(VistaFormulario vista) {
		super();
		this.vista = vista;
	
		indice = -1;
		inicializar();
	}

	private void inicializar() {
		
		// Add Action Listener
		vista.getBtnAdd().addActionListener(this);
		vista.getBtnNext().addActionListener(this);
		vista.getBtnPrevious().addActionListener(this);
		vista.getBtnNew().addActionListener(this);
		vista.getMntmSave().addActionListener(this);
		vista.getMntmOpen().addActionListener(this);
		
		
		// Add Action Command
		vista.getBtnAdd().setActionCommand("Add");
		vista.getBtnNext().setActionCommand("Next");
		vista.getBtnPrevious().setActionCommand("Previous");
		vista.getBtnNew().setActionCommand("New");
		vista.getMntmOpen().setActionCommand("Open");
		vista.getMntmSave().setActionCommand("Save");
		
		
	}
	
	public void go() {
		
		vista.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		
		if(comando.equals("New")) {
			
			newUser();
			
		} else if(comando.equals("Add")) {
			
			addUser();
			
		} else if(comando.equals("Previous")) {
			
			showPreviousUser();
			
		} else if(comando.equals("Next")) {
			
			showNextUser();
			
		} else if(comando.equals("Open")) {
			
			open();
			
		} else if(comando.equals("Save")) {
			
			save();
			
		}
		
		
	}

	
	private void open() {
		
		JFileChooser jfc = new JFileChooser();
		int opcion = jfc.showOpenDialog(vista);
		
		if(opcion == JFileChooser.APPROVE_OPTION) {
			
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()))) {
				
					personas = (ArrayList<Persona>)ois.readObject();
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(personas.size() != 0) {
			indice = personas.size();
			vista.getBtnPrevious().setEnabled(true);
		}
		
	}



	private void save() {
		
		JFileChooser jfc = new JFileChooser();
		int opcion = jfc.showSaveDialog(vista);
		
		if(opcion == JFileChooser.APPROVE_OPTION) {
			
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(jfc.getSelectedFile()))) {
				
				oos.writeObject(personas);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	}
	
	

	private void showPreviousUser() {
		
		for(Component c : vista.getPanelDatos().getComponents()) {
			if(c instanceof JTextField) {
				((JTextField)c).setEnabled(false);
				
			}
			if(c instanceof JComboBox) {
				((JComboBox)c).setEnabled(false);
			
			}
			
			
		}
		vista.getBtnNext().setEnabled(true);
		vista.getBtnNew().setEnabled(true);
		vista.getBtnAdd().setEnabled(false);
		if(indice > 0) {
			previousNext(-1);		
			indice --;
		} else {
			vista.getBtnPrevious().setEnabled(false);
		}
		
		
		
	}

	private void previousNext(int num) {
		vista.getTxtFieldName().setText(personas.get(indice + num).getName());
		vista.getTxtFieldSurname().setText(personas.get(indice + num).getSurname());
		vista.getTxtFieldAddress().setText(personas.get(indice + num).getAddress());
		vista.getComboBoxCity().setSelectedItem(personas.get(indice + num).getCity());
		vista.getTxtFieldPhone().setText(personas.get(indice + num).getPhone());
		vista.getTxtFieldDni().setText(personas.get(indice + num).getDNI());
		vista.getComboBoxAge().setSelectedItem(personas.get(indice + num).getAge());
		vista.getRdbtnMen().setSelected(personas.get(indice + num).getSexo().equals("Men"));
		vista.getRdbtnWomen().setSelected(personas.get(indice + num).getSexo().equals("Women"));
	}
	
	
	private void showNextUser() {
		
		vista.getBtnPrevious().setEnabled(true);
		if(indice < personas.size() -1) {
			previousNext(1);
			indice ++;
		} else {
			vista.getBtnNext().setEnabled(false);
		}
		
		
		
	}
	

	private void addUser() {
		
		
		boolean rellenado = true;
		for(Component c : vista.getPanelDatos().getComponents()) {
			if(c instanceof JTextField) {
				if(((JTextField)c).getText().equals("")){
					rellenado = false;
				}
				
			}
		
			
			
		}
		
		
		
		if(rellenado == false) {
			JOptionPane.showMessageDialog(null,"Rellena todos los campos","Aviso",JOptionPane.WARNING_MESSAGE);
		} else {
			if(vista.getRdbtnMen().isSelected()) {
				personas.add(new Persona(vista.getTxtFieldName().getText(),vista.getTxtFieldSurname().getText(),vista.getTxtFieldAddress().getText(),
						(String)vista.getComboBoxCity().getSelectedItem(),vista.getTxtFieldPhone().getText(),vista.getTxtFieldDni().getText(),
						(Integer)vista.getComboBoxAge().getSelectedItem(),vista.getRdbtnMen().getText()));
			} else {
				personas.add(new Persona(vista.getTxtFieldName().getText(),vista.getTxtFieldSurname().getText(),vista.getTxtFieldAddress().getText(),
						(String)vista.getComboBoxCity().getSelectedItem(),vista.getTxtFieldPhone().getText(),vista.getTxtFieldDni().getText(),
						(Integer)vista.getComboBoxAge().getSelectedItem(),vista.getRdbtnWomen().getText()));
			}
			
			vista.getBtnNew().setEnabled(true);
			vista.getBtnAdd().setEnabled(false);
			vista.getBtnPrevious().setEnabled(true);
			indice ++;
		}
		
		
		
	}

	private void newUser() {
		
		indice = personas.size();
		vista.getBtnAdd().setEnabled(true);
		vista.getRdbtnMen().setEnabled(true);
		vista.getRdbtnWomen().setEnabled(true);
		vista.getBtnNew().setEnabled(false);
		vista.getBtnNext().setEnabled(false);
		vista.getBtnPrevious().setEnabled(false);
		
		for(Component c : vista.getPanelDatos().getComponents()) {
			if(c instanceof JTextField) {
				((JTextField)c).setEnabled(true);
				((JTextField)c).setText("");
			}
			if(c instanceof JComboBox) {
				((JComboBox)c).setEnabled(true);
				((JComboBox)c).setSelectedIndex(0);
			}
		}
	}
	
	
	
}

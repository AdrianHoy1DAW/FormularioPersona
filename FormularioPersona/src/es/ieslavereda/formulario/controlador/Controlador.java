package es.ieslavereda.formulario.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Persona;
import vistas.VistaFormulario;

public class Controlador implements ActionListener{

	private VistaFormulario vista;
	private ArrayList<Persona> personas = new ArrayList<>();
	private int indice;

	public Controlador(VistaFormulario vista) {
		super();
		this.vista = vista;
	
		inicializar();
	}

	private void inicializar() {
		
		// Add Action Listener
		vista.getBtnAdd().addActionListener(this);
		vista.getBtnNext().addActionListener(this);
		vista.getBtnPrevious().addActionListener(this);
		vista.getBtnNew().addActionListener(this);
		
		
		// Add Action Command
		vista.getBtnAdd().setActionCommand("Add");
		vista.getBtnNext().setActionCommand("Next");
		vista.getBtnPrevious().setActionCommand("Previous");
		vista.getBtnNew().setActionCommand("New");
		
		
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
			
		}
		
		
	}

	
	private void showPreviousUser() {
		
		vista.getBtnNext().setEnabled(true);
		vista.getBtnNew().setEnabled(true);
		vista.getBtnAdd().setEnabled(false);
		if(indice > 0) {
			vista.getTxtFieldName().setText(personas.get(indice -1).getName());
			indice --;
		} else {
			JOptionPane.showMessageDialog(null,"No hay más personas","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}
	
	
	private void showNextUser() {
		
		
		if(indice < personas.size() -1) {
			vista.getTxtFieldName().setText(personas.get(indice +1).getName());
			indice ++;
		} else {
			JOptionPane.showMessageDialog(null,"No hay más personas","Error",JOptionPane.ERROR_MESSAGE);
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

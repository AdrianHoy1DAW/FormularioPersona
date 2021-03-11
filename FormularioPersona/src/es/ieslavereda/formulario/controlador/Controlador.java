package es.ieslavereda.formulario.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import vistas.VistaFormulario;

public class Controlador implements ActionListener{

	private VistaFormulario vista;

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
			
			
			
		} else if(comando.equals("Next")) {
			
			
			
		}
		
		
	}

	private void addUser() {
		
		
		
	}

	private void newUser() {
		
		vista.getBtnAdd().setEnabled(true);
		vista.getRdbtnMen().setEnabled(true);
		vista.getRdbtnWomen().setEnabled(true);
		
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

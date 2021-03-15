package es.ieslavereda.formulario;

import java.awt.EventQueue;

import es.ieslavereda.controlador.Controlador;
import es.ieslavereda.vistas.VistaFormulario;

public class App {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaFormulario frame = new VistaFormulario();
					Controlador c = new Controlador(frame);
					c.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


	}
}

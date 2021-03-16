package es.ieslavereda.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class VistaTabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm;
	private JButton btnDelete;

	/**
	 * Create the frame.
	 */
	public VistaTabla() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelTabla = new JPanel();
		
		JPanel panelBotones = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBotones, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(panelTabla, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addComponent(panelTabla, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnDelete = new JButton("Delete");
		panelBotones.add(btnDelete);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		dtm = new DefaultTableModel();
		dtm.addColumn("id");
		dtm.addColumn("DNI");
		dtm.addColumn("Nombre");
		dtm.addColumn("Apellidos");
		table.setModel(dtm);
		
		
		
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JTable getTable() {
		return table;
	}
	
	
	
	
}

package ungs.crm.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import ungs.crm.controller.*;
import ungs.crm.model.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrincipalVista extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalVista frame = new PrincipalVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalVista() {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}		
		catch (Exception e){}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMain = new JMenu("Main");
		menuBar.add(mnMain);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ClienteVistaDesktop vistaCli= new ClienteVistaDesktop();
				
				ClienteModelo modeloCli= ClienteModelo.getInstance();

				ClienteControlador controlCli = new ClienteControlador(vistaCli, modeloCli);

		        vistaCli.setVisible(true);
			}
		});
		
		mnMain.add(mntmClientes);
		
		JMenuItem mntmVerContactos = new JMenuItem("Ver contactos");
		
		mntmVerContactos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ContactoVistaDesktop vistaCont= new ContactoVistaDesktop();
				
				ContactoModelo modeloCont= new ContactoModelo();

				ContactoControlador controlCli = new ContactoControlador(vistaCont, modeloCont);

		        vistaCont.setVisible(true);
			}
		});
		
		JMenuItem mntmMensajes = new JMenuItem("Mensajes");
		
//		mntmMensajes.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				MensajeVistaDesktop vistaCont= new MensajeVistaDesktop();
//				
//				MensajeModelo modeloCont= new MensajeModelo();
//
//				MensajeControlador controlCli = new ContactoControlador(vistaCont, modeloCont);
//
//		        vistaCont.setVisible(true);
//			}
//		});
		
		mnMain.add(mntmMensajes);
		
		mnMain.add(mntmVerContactos);
		
		JMenuItem mntmVerEstados = new JMenuItem("Ver estados");
		
		mntmVerEstados.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				EstadoVistaDesktop vistaCli= new EstadoVistaDesktop();
				
				EstadoModelo modeloCli= new EstadoModelo();

		        EstadoControlador controlCli = new EstadoControlador(vistaCli, modeloCli);

		        vistaCli.setVisible(true);
			}
		});
		
		
		mnMain.add(mntmVerEstados);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTextField;

import Arbol.arbolAVL;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaAVL {

	private JFrame frame;
	private JTextField txtIngreso;
	
	arbolAVL nuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaAVL window = new vistaAVL();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vistaAVL() {
		initialize();
		nuevo=new arbolAVL();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 623, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblArbolAvl = new JLabel("Arbol AVL");
		lblArbolAvl.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblArbolAvl.setBounds(320, 21, 109, 21);
		frame.getContentPane().add(lblArbolAvl);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 58, 153, 150);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIngresar = new JLabel("Ingresar:");
		lblIngresar.setBounds(10, 31, 63, 14);
		panel.add(lblIngresar);
		
		txtIngreso = new JTextField();
		txtIngreso.setBounds(78, 28, 45, 20);
		panel.add(txtIngreso);
		txtIngreso.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int valor=Integer.parseInt(txtIngreso.getText());
					nuevo.insertar(valor);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnIngresar.setBounds(10, 74, 88, 23);
		panel.add(btnIngresar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(10, 111, 89, 23);
		panel.add(btnMostrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(235, 92, 362, 106);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(10, 11, 342, 83);
		panel_1.add(txtArea);
		
		JLabel lblPreorden = new JLabel("PRE-ORDEN");
		lblPreorden.setBounds(250, 58, 93, 14);
		frame.getContentPane().add(lblPreorden);
		
		
		//
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtArea.setText(nuevo.preorden());
					
				} catch (Exception ev) {
					// TODO: handle exception
				}
			}
		});
	}
}

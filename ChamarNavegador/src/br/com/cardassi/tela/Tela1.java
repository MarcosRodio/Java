package br.com.cardassi.tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Tela1 extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField texttelefone;
	private JTextField textddd;
	protected Process exec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 frame = new Tela1();
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
	public Tela1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setBounds(111, 14, 62, 14);
		panel.add(lblTelefone);
		
		texttelefone = new JTextField();
		texttelefone.setBounds(183, 11, 86, 20);
		texttelefone.setHorizontalAlignment(SwingConstants.CENTER);
		texttelefone.setColumns(10);
		panel.add(texttelefone);
		
		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblDdd.setBounds(10, 14, 46, 14);
		panel.add(lblDdd);
		
		textddd = new JTextField();
		textddd.setHorizontalAlignment(SwingConstants.CENTER);
		textddd.setColumns(10);
		textddd.setBounds(60, 11, 36, 20);
		panel.add(textddd);
		
		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			private Process exec;

			public void actionPerformed(ActionEvent e) {
				try {
					String ddi = "55";
					exec = Runtime.getRuntime().exec("cmd /c start https://wa.me/"+ddi+textddd.getText()+texttelefone.getText()+"?text=MRZAP%20MELHOR%20QUE%20O%20DO%20TIAGO!!&app_absent=1");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(156, 199, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnCalc = new JButton("Calc");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					exec = Runtime.getRuntime().exec("cmd /c start calc.exe");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCalc.setBounds(7, 104, 89, 49);
		panel.add(btnCalc);
		
		JButton btnSublime = new JButton("Sublime");
		btnSublime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					exec = Runtime.getRuntime().exec("cmd /c start Sublime text 3");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnSublime.setBounds(106, 104, 89, 49);
		panel.add(btnSublime);
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.setBounds(226, 104, 89, 49);
		panel.add(btnExcel);
		
		JButton btnPBI = new JButton("Power BI");
		btnPBI.setBounds(325, 104, 89, 49);
		panel.add(btnPBI);
	}
}

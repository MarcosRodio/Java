package Cadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class Janela1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCod;
	private JTextField textNome;
	private JLabel lblEndero;
	private JTextField textendereco;
	private JLabel lblNumero;
	private JTextField textnumero;
	private JLabel lblBairro;
	private JTextField textbairro;
	private JLabel lblBairro_1;
	private JTextField textcidade;
	private JLabel lblCep;
	private JTextField textCep;
	private JTextField textcomplemento;
	private JTextField textestado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela1 frame = new Janela1();
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
	public Janela1() {
		setResizable(false);
		setTitle("Endere\u00E7o");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCod = new JLabel("C\u00F3digo:");
		lblCod.setBounds(10, 22, 46, 14);
		contentPane.add(lblCod);
		
		textCod = new JTextField();
		textCod.setBounds(10, 40, 86, 20);
		contentPane.add(textCod);
		textCod.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 65, 414, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(10, 83, 386, 20);
		contentPane.add(textNome);
		
		lblEndero = new JLabel("Endere\u00E7o:");
		lblEndero.setBounds(10, 109, 86, 14);
		contentPane.add(lblEndero);
		
		textendereco = new JTextField();
		textendereco.setColumns(10);
		textendereco.setBounds(10, 127, 235, 20);
		contentPane.add(textendereco);
		
		lblNumero = new JLabel("N\u00BA:");
		lblNumero.setBounds(255, 109, 27, 14);
		contentPane.add(lblNumero);
		
		textnumero = new JTextField();
		textnumero.setColumns(10);
		textnumero.setBounds(255, 127, 46, 20);
		contentPane.add(textnumero);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 158, 46, 14);
		contentPane.add(lblBairro);
		
		textbairro = new JTextField();
		textbairro.setColumns(10);
		textbairro.setBounds(10, 176, 92, 20);
		contentPane.add(textbairro);
		
		lblBairro_1 = new JLabel("Cidade:");
		lblBairro_1.setBounds(112, 158, 114, 14);
		contentPane.add(lblBairro_1);
		
		textcidade = new JTextField();
		textcidade.setColumns(10);
		textcidade.setBounds(112, 176, 133, 20);
		contentPane.add(textcidade);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(313, 158, 46, 14);
		contentPane.add(lblCep);
		
		textCep = new JTextField();
		textCep.setColumns(10);
		textCep.setBounds(310, 176, 86, 20);
		contentPane.add(textCep);
		
		JButton btnincluir = new JButton("Incluir");
		btnincluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teste = "Confirma a inclusão do endereço informado?";
				JOptionPane.showConfirmDialog(btnincluir, teste);
			}
		});
		btnincluir.setBounds(98, 215, 89, 35);
		contentPane.add(btnincluir);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textbairro.setText("");
				textCep.setText("");
				textcidade.setText("");
				textCod.setText("");
				textcomplemento.setText("");
				textendereco.setText("");
				textestado.setText("");
				textNome.setText("");
				textnumero.setText("");
			}
		});
		btnNewButton_1.setBounds(255, 215, 89, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(310, 109, 74, 14);
		contentPane.add(lblComplemento);
		
		textcomplemento = new JTextField();
		textcomplemento.setColumns(10);
		textcomplemento.setBounds(310, 127, 86, 20);
		contentPane.add(textcomplemento);
		
		JLabel lblEstado = new JLabel("UF:");
		lblEstado.setBounds(255, 158, 68, 14);
		contentPane.add(lblEstado);
		
		textestado = new JTextField();
		textestado.setColumns(10);
		textestado.setBounds(255, 176, 46, 20);
		contentPane.add(textestado);

	}
	
	public class arquivo {
		
		String nome = "";
		String codigo = "";
	}
	
	public class lista{
		
		JList<arquivo> arq = new JList<>();
	}
	    
}

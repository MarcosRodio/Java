package Cadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Tela1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_3;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 5, 764, 116);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CADASTRO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(29, 22, 59, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(98, 19, 224, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O:");
		lblEndereo.setToolTipText("");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setBounds(10, 50, 78, 14);
		panel.add(lblEndereo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 47, 224, 20);
		panel.add(textField_1);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setToolTipText("");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(10, 78, 78, 14);
		panel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(98, 75, 224, 20);
		panel.add(textField_2);
		
		JLabel lblTelefone_1 = new JLabel("DDD:");
		lblTelefone_1.setToolTipText("");
		lblTelefone_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone_1.setBounds(328, 22, 96, 14);
		panel.add(lblTelefone_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(434, 19, 47, 20);
		panel.add(textField_4);
		
		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setToolTipText("");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setBounds(346, 50, 78, 14);
		panel.add(lblCidade);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(434, 47, 142, 20);
		panel.add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SP", "MS", "RJ"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(642, 45, 47, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("UF:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(603, 49, 29, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblTelefone_1_1 = new JLabel("TELEFONE:");
		lblTelefone_1_1.setToolTipText("");
		lblTelefone_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone_1_1.setBounds(488, 22, 78, 14);
		panel.add(lblTelefone_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(574, 19, 115, 20);
		panel.add(textField_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("FEMININO");
		rdbtnNewRadioButton.setBounds(498, 74, 78, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFeminino = new JRadioButton("MASCULINO");
		rdbtnFeminino.setBounds(580, 74, 109, 23);
		panel.add(rdbtnFeminino);
		
		JLabel lblNewLabel_2 = new JLabel("SEXO:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(446, 78, 46, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "CURSOS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 317, 769, 233);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "HIST\u00D3RICO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 129, 721, 157);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(SystemColor.menu);
		editorPane.setBounds(21, 21, 677, 125);
		panel_2.add(editorPane);
	}
}

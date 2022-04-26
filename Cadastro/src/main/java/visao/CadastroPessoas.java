package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Infra.DAO;
import Modelo.Pessoa;

public class CadastroPessoas extends JFrame {

	String nome, cpf, email;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Nome;
	private JTextField textField_Email;
	private JTextField textField_CPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPessoas frame = new CadastroPessoas();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroPessoas() {
		setTitle("CADASTRO DE PESSOAS");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 608, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 69, 45, 14);
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNome);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setVerticalAlignment(SwingConstants.TOP);
		lblEmail.setBounds(10, 103, 45, 14);
		panel.add(lblEmail);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setVerticalAlignment(SwingConstants.TOP);
		lblCpf.setBounds(10, 140, 31, 14);
		panel.add(lblCpf);

		textField_Nome = new JTextField();
		textField_Nome.setBounds(65, 66, 240, 20);
		panel.add(textField_Nome);
		textField_Nome.setColumns(10);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(65, 100, 200, 20);
		panel.add(textField_Email);
		try {
		textField_CPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, e1);
			
			e1.printStackTrace();
		}
		textField_CPF.setColumns(10);
		textField_CPF.setBounds(65, 137, 160, 20);
		panel.add(textField_CPF);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nome = textField_Nome.getText();
				email = textField_Email.getText();
				cpf = textField_CPF.getText();
				Pessoa pessoa = new Pessoa(nome, email, cpf);

				DAO<Pessoa> dao = new DAO<Pessoa>();
				dao.incluirAtomico(pessoa);

				textField_CPF.setText(null);
				textField_Email.setText(null);
				textField_Nome.setText(null);

				JOptionPane.showMessageDialog(null, "Cadastrado");

			}
		});
		btnInserir.setForeground(Color.BLUE);
		btnInserir.setBounds(65, 217, 89, 23);
		panel.add(btnInserir);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_CPF.setText(null);
				textField_Email.setText(null);
				textField_Nome.setText(null);

			}
		});
		btnCancelar.setForeground(Color.RED);
		btnCancelar.setBounds(177, 217, 89, 23);
		panel.add(btnCancelar);

		JLabel lblNewLabel = new JLabel("INFORME OS DADOS PESSOAIS ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 404, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(CadastroPessoas.class.getResource("/Images/CADASTRO.png")));
		lblNewLabel_1.setBounds(325, 19, 231, 256);
		panel.add(lblNewLabel_1);

	}
}

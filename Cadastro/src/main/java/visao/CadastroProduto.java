package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Infra.DAO;
import Modelo.Produto;

public class CadastroProduto extends JFrame {

	String nome_prod;
	double preco;
	int unidade;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_NProduto;
	private JTextField textField_Preco;
	private JTextField textField_Unidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto();
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
	public CadastroProduto() {
		setTitle("CADASTRO DE PRODUTOS");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 608, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("INFORME OS DADOS DO PRODUTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Produto:");
		lblNewLabel_1.setBounds(10, 58, 58, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o:");
		lblNewLabel_2.setBounds(10, 97, 58, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Unidade:");
		lblNewLabel_3.setBounds(10, 137, 58, 14);
		contentPane.add(lblNewLabel_3);

		textField_NProduto = new JTextField();
		textField_NProduto.setBounds(78, 55, 146, 20);
		contentPane.add(textField_NProduto);
		textField_NProduto.setColumns(10);

		textField_Preco = new JTextField();
		textField_Preco.setBounds(78, 94, 86, 20);
		contentPane.add(textField_Preco);
		textField_Preco.setColumns(10);

		textField_Unidade = new JTextField();
		textField_Unidade.setBounds(78, 134, 46, 20);
		contentPane.add(textField_Unidade);
		textField_Unidade.setColumns(10);

		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome_prod = textField_NProduto.getText();
				preco = Double.parseDouble(textField_Preco.getText().replace("," , "."));
				unidade = Integer.parseInt(textField_Unidade.getText());

				Produto prod = new Produto(nome_prod, preco, unidade);

				DAO<Produto> dao = new DAO<Produto>();
				dao.incluirAtomico(prod);

				JOptionPane.showMessageDialog(null, "Cadastrado");
			}
		});
		btnNewButton.setBounds(98, 224, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_NProduto.setText(null);
				textField_Preco.setText(null);
				textField_Unidade.setText(null);
			}

		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(197, 224, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(CadastroProduto.class.getResource("/Images/CADASTRO.png")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(347, 11, 235, 278);
		contentPane.add(lblNewLabel_4);
	}
}

package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Infra.DAO;
import Modelo.Produto;

public class PesquisaProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFPProduto;
	private JTextField tfPNome;
	private JTextField TfPPreco;
	private JTextField TFPunidade;
	String pesquisa;
	Produto prod1 = new Produto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaProduto frame = new PesquisaProduto();
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
	public PesquisaProduto() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 608, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDescrioDoProduto = new JLabel("DESCRI\u00C7\u00C3O DO PRODUTO");
		lblDescrioDoProduto.setBounds(5, 5, 582, 15);
		lblDescrioDoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrioDoProduto.setForeground(Color.BLUE);
		lblDescrioDoProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblDescrioDoProduto);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o: ");
		lblDescricao.setBounds(10, 62, 66, 14);
		contentPane.add(lblDescricao);

		tFPProduto = new JTextField();
		tFPProduto.setBounds(86, 59, 153, 20);
		contentPane.add(tFPProduto);
		tFPProduto.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 94, 572, 7);
		contentPane.add(separator);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setVisible(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DAO<Produto> dao = new DAO<>();
				dao.remove(prod1);
				JOptionPane.showMessageDialog(null, "Produto Excluido com Sucesso!");
				tfPNome.setText("");
				TfPPreco.setText("");
				tFPProduto.setText("");
				TFPunidade.setText("");

				
			
			}
			
		});
		btnExcluir.setForeground(Color.RED);
		btnExcluir.setBounds(74, 283, 89, 23);
		contentPane.add(btnExcluir);

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pesquisa = tFPProduto.getText();

				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cadastro");

				EntityManager em = emf.createEntityManager();
				try {
					String jpql = "select * from Produtos p where p.nome LIKE " + "'%" + pesquisa + "%'";
					@SuppressWarnings("unchecked")
					TypedQuery<Produto> tp = (TypedQuery<Produto>) em.createNativeQuery(jpql, Produto.class);
					prod1 = tp.getSingleResult();

					tfPNome.setText(prod1.getNome());
					String preco = String.valueOf(prod1.getPreco());
					tfPNome.setEditable(false);
					TfPPreco.setText(preco);
					String unidade = String.valueOf(prod1.getUnidades());
					TfPPreco.setEditable(false);
					TFPunidade.setText(unidade);
					TFPunidade.setEditable(false);
				} catch (NoResultException e1) {
					JOptionPane.showMessageDialog(null, "PRODUTO NÃO CADASTRADO");
				}
				em.close();
				emf.close();
				btnExcluir.setVisible(true);
			}
		});

		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(267, 58, 101, 23);
		contentPane.add(btnNewButton);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 131, 66, 14);
		contentPane.add(lblNome);

		tfPNome = new JTextField();
		tfPNome.setColumns(10);
		tfPNome.setBounds(86, 128, 153, 20);
		contentPane.add(tfPNome);

		JLabel lblPreo = new JLabel("Pre\u00E7o: ");
		lblPreo.setBounds(10, 180, 66, 14);
		contentPane.add(lblPreo);

		TfPPreco = new JTextField();
		TfPPreco.setColumns(10);
		TfPPreco.setBounds(86, 177, 77, 20);
		contentPane.add(TfPPreco);

		JLabel lblUnidades = new JLabel("Unidades: ");
		lblUnidades.setBounds(10, 230, 66, 14);
		contentPane.add(lblUnidades);

		TFPunidade = new JTextField();
		TFPunidade.setColumns(10);
		TFPunidade.setBounds(86, 227, 36, 20);
		contentPane.add(TFPunidade);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(PesquisaProduto.class.getResource("/Images/Pesquisar.png")));
		lblNewLabel.setBounds(381, 94, 201, 182);
		contentPane.add(lblNewLabel);

		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLUE);
		btnSalvar.setVisible(false);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cadastro");

				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				prod1 = em.find(Produto.class, prod1.getId());
				prod1.setNome(tfPNome.getText());
				prod1.setPreco(Double.parseDouble(TfPPreco.getText()));
				prod1.setUnidades(Integer.parseInt(TFPunidade.getText()));
				em.getTransaction().commit(); // finaliza a transação
				JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");
				
				
				btnSalvar.setVisible(false);
			}
		});
		btnSalvar.setBounds(406, 283, 89, 23);
		contentPane.add(btnSalvar);


		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfPNome.setText("");
				TfPPreco.setText("");
				tFPProduto.setText("");
				TFPunidade.setText("");
				btnSalvar.setVisible(false);
			}
		});
		btnLimpar.setForeground(Color.RED);
		btnLimpar.setBounds(186, 283, 89, 23);
		contentPane.add(btnLimpar);

		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfPNome.setEditable(true);
				TfPPreco.setEditable(true);
				TFPunidade.setEditable(true);
				btnSalvar.setVisible(true);

			}
		});
		btnAlterar.setBounds(297, 283, 89, 23);
		contentPane.add(btnAlterar);

	}
}
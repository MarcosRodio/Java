package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Infra.DAO;
import Modelo.Pessoa;
import java.awt.Component;

public class PesquisaPessoa extends JFrame {

	String pesquisa;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFPCpf;
	private JTextField tFNome;
	private JTextField tFEmail;
	private JTextField tFCpf;
	private JTextField tF_id;
	Pessoa p1 = new Pessoa();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaPessoa frame = new PesquisaPessoa();
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
	public PesquisaPessoa() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("PESQUISA PESSOAS");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 608, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			TFPCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, e1);

			e1.printStackTrace();
		}
		TFPCpf.setBounds(92, 63, 200, 20);
		contentPane.add(TFPCpf);
		TFPCpf.setColumns(10);

		JLabel lblNewLabel = new JLabel("C.P.F");
		lblNewLabel.setBounds(20, 66, 57, 14);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(416, 113, -427, 29);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 94, 572, 7);
		contentPane.add(separator_1);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(24, 167, 46, 14);
		contentPane.add(lblNewLabel_1);

		tFNome = new JTextField();
		tFNome.setBounds(92, 164, 240, 20);
		contentPane.add(tFNome);
		tFNome.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		lblNewLabel_1_1.setBounds(24, 199, 46, 14);
		contentPane.add(lblNewLabel_1_1);

		tFEmail = new JTextField();
		tFEmail.setColumns(10);
		tFEmail.setBounds(92, 196, 200, 20);
		contentPane.add(tFEmail);

		JLabel lblNewLabel_1_2 = new JLabel("CPF:");
		lblNewLabel_1_2.setBounds(24, 233, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		try {
			tFCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, e1);

			e1.printStackTrace();
		}
		tFCpf.setColumns(10);
		tFCpf.setBounds(92, 230, 160, 20);
		contentPane.add(tFCpf);

		JLabel lblPesquisa = new JLabel("Dados da Pessoa");
		lblPesquisa.setForeground(Color.BLUE);
		lblPesquisa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPesquisa.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisa.setBounds(10, 100, 424, 14);
		contentPane.add(lblPesquisa);

		JLabel lblNewLabel_1_3 = new JLabel(" ID:");
		lblNewLabel_1_3.setBounds(20, 133, 46, 14);
		contentPane.add(lblNewLabel_1_3);

		tF_id = new JTextField();
		tF_id.setColumns(10);
		tF_id.setBounds(92, 130, 57, 20);
		contentPane.add(tF_id);

		JLabel lblTitulo = new JLabel("INFOME O NOME PARA PESQUISAR");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.BLUE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(10, 11, 424, 14);
		contentPane.add(lblTitulo);

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisa = TFPCpf.getText();

				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cadastro");

				EntityManager em = emf.createEntityManager();
				try {
					String jpql = "select * from Pessoa p where p.cpf = " + "'" + pesquisa + "'";
					@SuppressWarnings("unchecked")
					TypedQuery<Pessoa> tp = (TypedQuery<Pessoa>) em.createNativeQuery(jpql, Pessoa.class);

					p1 = (Pessoa) tp.getSingleResult();
					String id = Long.toString(p1.getId());
					tF_id.setText(id);
					tF_id.setEditable(false);
					tFCpf.setText(p1.getCpf());
					tFCpf.setEditable(false);
					tFNome.setText(p1.getNome());
					tFNome.setEditable(false);
					tFEmail.setText(p1.getEmail());
					tFEmail.setEditable(false);

				} catch (NoResultException e1) {
					JOptionPane.showMessageDialog(null, "CLIENTE NÃO CADASTRADO");
				}
				em.close();
				emf.close();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(302, 62, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluir.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnExcluir.setForeground(Color.RED);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO<Pessoa> dao = new DAO<>();
				dao.remove(p1);
				JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso!");

				tF_id.setText("");
				tFCpf.setText("");
				tFNome.setText("");
				tFEmail.setText("");
			}
		});
		btnExcluir.setBounds(92, 274, 89, 23);
		contentPane.add(btnExcluir);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(Color.RED);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TFPCpf.setText("");
				tF_id.setText("");
				tFCpf.setText("");
				tFNome.setText("");
				tFEmail.setText("");
			}
		});
		btnLimpar.setBounds(203, 274, 89, 23);
		contentPane.add(btnLimpar);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(PesquisaPessoa.class.getResource("/Images/Pesquisar.png")));
		lblNewLabel_2.setBounds(416, 125, 127, 114);
		contentPane.add(lblNewLabel_2);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLUE);
		btnSalvar.setVisible(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cadastro");

				EntityManager em = emf.createEntityManager();

				em.getTransaction().begin();
				p1 = em.find(Pessoa.class, p1.getId());
				p1.setNome(tFNome.getText());
				p1.setEmail(tFEmail.getText());
				p1.setCpf(tFCpf.getText());
				em.getTransaction().commit(); // finaliza a transação
				JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!");
				TFPCpf.setText("");
				tF_id.setText("");
				tFCpf.setText("");
				tFNome.setText("");
				tFEmail.setText("");
				btnSalvar.setVisible(false);
				em.close();
				emf.close();

			}
		});
		btnSalvar.setBounds(431, 274, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvar.setVisible(true);

				tFCpf.setEditable(true);
				tFNome.setEditable(true);
				tFEmail.setEditable(true);

			}
		});
		btnAlterar.setBounds(317, 274, 89, 23);
		contentPane.add(btnAlterar);
	}
}

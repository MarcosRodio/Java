package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends javax.swing.JFrame {
		
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CadastroPessoas pessoa = new CadastroPessoas();
	private CadastroProduto produto = new CadastroProduto();
	private PesquisaPessoa PesqPessoa = new PesquisaPessoa();
	private PesquisaProduto pesquisaProduto = new PesquisaProduto();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
					frame.setSize(800,600);
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
	public MenuPrincipal() {
		setTitle("MENU PRINCIPAL");
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 606);
		

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu Menu_Cadastro = new JMenu("Cadastro");
		Menu_Cadastro.setHorizontalAlignment(SwingConstants.LEFT);
		Menu_Cadastro.setIcon(null);
		menuBar.add(Menu_Cadastro);

		JMenuItem Cad_Pessoas = new JMenuItem("Pessoas");
		Cad_Pessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoa.setVisible(true);
			}
			
		});
		
		Cad_Pessoas.setSelectedIcon(null);
		Cad_Pessoas.setIcon(null);
		Cad_Pessoas.setHorizontalAlignment(SwingConstants.LEFT);
		Menu_Cadastro.add(Cad_Pessoas);

		JMenuItem Cad_Produtos = new JMenuItem("Produtos");
		Cad_Produtos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produto.setVisible(true);
			}
		});
		Cad_Produtos.setSelectedIcon(null);
		Cad_Produtos.setIcon(null);
		Cad_Produtos.setHorizontalAlignment(SwingConstants.CENTER);
		Menu_Cadastro.add(Cad_Produtos);

		JMenu Menu_Pesquisa = new JMenu("Pesquisa");
		Menu_Pesquisa.setIcon(null);
		menuBar.add(Menu_Pesquisa);

		JMenuItem Proc_Pessoas = new JMenuItem("Pessoas");
		Proc_Pessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesqPessoa.setVisible(true);
			}
		});
		Menu_Pesquisa.add(Proc_Pessoas);

		JMenuItem Proc_Produtos = new JMenuItem("Produtos");
		Proc_Produtos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pesquisaProduto.setVisible(true);
			}
		});
		Menu_Pesquisa.add(Proc_Produtos);
		
		JMenu mnNewMenu = new JMenu("Utilit\u00E1rios");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Calculadora");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			private Process exec;

			public void actionPerformed(ActionEvent e) {
				try {
					
					exec = Runtime.getRuntime().exec("C:\\Windows\\System32\\calc.exe");
					//exec = Runtime.getRuntime().exec("cmd /c start https://wa.me/5518996043700?text=MRZAP%20MELHOR%20QUE%20O%20DO%20TIAGO!!&app_absent=1");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}

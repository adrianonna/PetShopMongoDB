package aplicacaoSwing;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;
import modelo.Raca;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;
	private JLabel imagemFundo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Pet Shop - Home");
		frame.setResizable(false);
		frame.setBounds(550, 350, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Fachada.inicializar();
				JOptionPane.showMessageDialog(null, "Sistema inicializado, seja bem vindo(a)!");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(null, "Sistema encerrado, ate breve!");
			}
		});
		
		// botoes da tela
		JButton btnListagens = new JButton("Listagens");
		btnListagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagem telaListagem = new TelaListagem();
				telaListagem.setVisible(true);
			}
		});
		btnListagens.setBounds(60, 54, 106, 46);
		btnListagens.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(btnListagens);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultas telaConsultas = new TelaConsultas();
				telaConsultas.setVisible(true);
			}
		});
		btnConsultas.setBounds(60, 134, 106, 46);
		btnConsultas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(btnConsultas);
		
		JButton btnAtendimento = new JButton("Atendimento");
		btnAtendimento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAtendimento telaCadAtende = new TelaCadastroAtendimento();
			}
		});
		btnAtendimento.setBounds(60, 217, 106, 46);
		frame.getContentPane().add(btnAtendimento);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDeletar telaDelete = new TelaDeletar();
			}
		});
		btnDeletar.setBounds(60, 301, 106, 46);
		frame.getContentPane().add(btnDeletar);
		
		// imagem de fundo
		imagemFundo = new JLabel("");
		imagemFundo.setBounds(0, 0, 634, 430);
		imagemFundo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/adorable-puppy.jpg")));
		frame.getContentPane().add(imagemFundo);
		
		
		// menu
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		// clientes
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnClientes);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroCliente telaCadCliente = new TelaCadastroCliente();
			}
		});
		mnClientes.add(mntmCadastrarCliente);
		
		JMenuItem mntmAtualizarCli = new JMenuItem("Atualizar");
		mntmAtualizarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarCliente telaAtualizarCliente = new TelaAtualizarCliente();
			}
		});
		mnClientes.add(mntmAtualizarCli);
		
		// animais
		JMenu mnAnimais = new JMenu("Animais");
		mnAnimais.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnAnimais);
		
		JMenuItem mntmCadastrarAnimal = new JMenuItem("Cadastrar/Cliente");
		mntmCadastrarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAnimal telaCadAnimal = new TelaCadastroAnimal();
			}
		});
		mnAnimais.add(mntmCadastrarAnimal);
		
		// servicos
		JMenu mnServicos = new JMenu("Servicos");
		mnServicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnServicos);
		
		JMenuItem mntmCadastrarServico = new JMenuItem("Cadastrar");
		mntmCadastrarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroServico telaCadServico = new TelaCadastroServico();
			}
		});
		mnServicos.add(mntmCadastrarServico);
		
		JMenuItem mntmAtualizarServ = new JMenuItem("Atualizar");
		mntmAtualizarServ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarServico telaAtualizarServ = new TelaAtualizarServico();
			}
		});
		mnServicos.add(mntmAtualizarServ);
		
		// produtos
		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnProdutos);
		
		JMenuItem mntmCadastrarProduto = new JMenuItem("Cadastrar");
		mntmCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto telaCadProduto = new TelaCadastroProduto();
			}
		});
		mnProdutos.add(mntmCadastrarProduto);
		
		JMenuItem mntmAtualizarProd = new JMenuItem("Atualizar");
		mntmAtualizarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarProduto telaAtualizarProd = new TelaAtualizarProduto();
			}
		});
		mnProdutos.add(mntmAtualizarProd);
		
		JMenu mnRaca = new JMenu("Raca");
		menuBar.add(mnRaca);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroRaca telaCadRaca = new TelaCadastroRaca();
			}
		});
		mnRaca.add(mntmCadastrar);
	}
}

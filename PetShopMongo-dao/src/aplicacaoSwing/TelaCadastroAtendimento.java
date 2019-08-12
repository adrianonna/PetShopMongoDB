package aplicacaoSwing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import fachada.Fachada;
import modelo.Atendimento;
import modelo.Produto;
import modelo.Servico;

public class TelaCadastroAtendimento {

	private JFrame frameCadastroAtendimento;
	private JTextField textFieldNome;
	private JTextField textFieldFunc;
	private JButton btnCadastrar;
	private JTextArea textAreaProd;
	private JTextArea textAreaServ;
	private Atendimento atendimento;
	private JComboBox<String> comboBoxProd;
	private JComboBox<String> comboBoxServ;

	/**
	 * Create the application.
	 */
	public TelaCadastroAtendimento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCadastroAtendimento = new JFrame("Pet Shop - Cadastro atendimento");
		frameCadastroAtendimento.setBounds(600, 350, 500, 475);
		frameCadastroAtendimento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastroAtendimento.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("* Nome do animal:");
		lblNome.setBounds(9, 64, 119, 14);
		frameCadastroAtendimento.getContentPane().add(lblNome);
		
		JLabel lblPreco = new JLabel("* Nome funcionario:");
		lblPreco.setBounds(9, 112, 131, 14);
		frameCadastroAtendimento.getContentPane().add(lblPreco);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(150, 57, 133, 28);
		frameCadastroAtendimento.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldFunc = new JTextField();
		textFieldFunc.setColumns(10);
		textFieldFunc.setBounds(150, 105, 133, 28);
		frameCadastroAtendimento.getContentPane().add(textFieldFunc);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate data = LocalDate.now();
				
				if (textFieldNome.getText().isEmpty() && textFieldFunc.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				} else {
					try {
						atendimento = Fachada.cadastrarAtendimento(data, textFieldFunc.getText(), textFieldNome.getText());
						btnCadastrar.setEnabled(false);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				}
		});
		btnCadastrar.setBounds(317, 76, 119, 41);
		frameCadastroAtendimento.getContentPane().add(btnCadastrar);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(9, 185, 145, 14);
		frameCadastroAtendimento.getContentPane().add(lblProdutos);
		
		JLabel lblServicos = new JLabel("Servicos");
		lblServicos.setBounds(276, 185, 145, 14);
		frameCadastroAtendimento.getContentPane().add(lblServicos);
		
		JButton btnAddProd = new JButton("Add");
		btnAddProd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAddProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = atendimento.getId();
				try {
					Fachada.adicionarProdutoAtendimento(id, comboBoxProd.getSelectedItem().toString());
					List<Produto> prods = atendimento.getProdutos();
					String txt = " ";
					for (Produto prod : prods) {
						txt += prod.getNome()+ " - R$ " + prod.getPreco() + "\n";
					}
					textAreaProd.setText(txt);						
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());				}
			}
		});
		btnAddProd.setBounds(157, 209, 60, 23);
		frameCadastroAtendimento.getContentPane().add(btnAddProd);
		
		JButton btnAddServ = new JButton("Add");
		btnAddServ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = atendimento.getId();
				try {
					Fachada.adicionarServicoAtendimento(id, comboBoxServ.getSelectedItem().toString());;
					List<Servico> servs = atendimento.getServicos();
					String txt = " ";
					for (Servico serv : servs) {
						txt += serv.getNome()+ " - R$ " + serv.getPreco() + "\n";
					}
					textAreaServ.setText(txt);						
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
			}}
		});
		btnAddServ.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAddServ.setBounds(412, 209, 60, 23);
		frameCadastroAtendimento.getContentPane().add(btnAddServ);
		
		textAreaProd = new JTextArea();
		JScrollPane scrollPaneProd = new JScrollPane(textAreaProd);
		scrollPaneProd.setBounds(9, 236, 208, 145);
		scrollPaneProd.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneProd.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frameCadastroAtendimento.getContentPane().add(scrollPaneProd);
		
		
		
		textAreaServ = new JTextArea();
		JScrollPane scrollPaneServ = new JScrollPane(textAreaServ);
		scrollPaneServ.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneServ.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneServ.setBounds(275, 236, 199, 145);
		frameCadastroAtendimento.getContentPane().add(scrollPaneServ);
		
		comboBoxProd = new JComboBox<String>();
		comboBoxProd.setBounds(9, 210, 145, 20);
		
		comboBoxProd.addItem("Escolha um produto...");
		// adicionar produtos ao comboBox
		List<Produto> produtos = Fachada.todosProdutos();
		for (Produto prod : produtos) {
			comboBoxProd.addItem(prod.getNome());			
		}
		frameCadastroAtendimento.getContentPane().add(comboBoxProd);
		
		comboBoxServ = new JComboBox<String>();
		comboBoxServ.setBounds(276, 210, 133, 20);
		// adicionar servico ao comboBox
		comboBoxServ.addItem("Escolha um servico");
		List<Servico> servicos = Fachada.todosServicos();
		for (Servico serv : servicos) {
			comboBoxServ.addItem(serv.getNome());
		}
		frameCadastroAtendimento.getContentPane().add(comboBoxServ);
		
		JButton btnEncerrar = new JButton("Encerrar");
		btnEncerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameCadastroAtendimento.dispose();
			}
		});
		btnEncerrar.setBounds(194, 402, 89, 23);
		frameCadastroAtendimento.getContentPane().add(btnEncerrar);
		
		
		frameCadastroAtendimento.setVisible(true);
	}
}

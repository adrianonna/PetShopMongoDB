package aplicacaoSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Produto;

import javax.swing.JComboBox;

public class TelaAtualizarProduto {

	private JFrame frameCadastroCliente;
	private JTextField textFieldNome;
	private JTextField textFieldPreco;
	private JButton btnAtualizar;
	private JComboBox<Produto> comboBox;
	private JButton btnOk;
	private JLabel lbMsg;


	/**
	 * Create the application.
	 */
	public TelaAtualizarProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCadastroCliente = new JFrame("Pet Shop - Atualizar produto");
		frameCadastroCliente.setBounds(600, 350, 500, 430);
		frameCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastroCliente.getContentPane().setLayout(null);
		
		
		JLabel lblNome = new JLabel("* Nome:");
		lblNome.setBounds(46, 130, 82, 14);
		frameCadastroCliente.getContentPane().add(lblNome);
		
		JLabel lblPreco = new JLabel("*  Preco:");
		lblPreco.setBounds(46, 192, 79, 14);
		frameCadastroCliente.getContentPane().add(lblPreco);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(115, 123, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
		textFieldPreco.setBounds(115, 185, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldPreco);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				} else {
					try {
						Double preco = Double.parseDouble(textFieldPreco.getText());
						Fachada.atualizarProduto(textFieldNome.getText(), preco);
						lbMsg.setText("Produto atualizado!");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				textFieldNome.setText("");
				textFieldPreco.setText("");
			}
		});
		btnAtualizar.setBounds(184, 316, 119, 41);
		frameCadastroCliente.getContentPane().add(btnAtualizar);
		
		JLabel lblBuscarCliente = new JLabel("Produtos:");
		lblBuscarCliente.setBounds(49, 45, 95, 14);
		frameCadastroCliente.getContentPane().add(lblBuscarCliente);
		
		comboBox = new JComboBox<Produto>();
		comboBox.setBounds(115, 38, 248, 28);
		// adicionar produtos ao comboBox
		List<Produto> produtos = Fachada.todosProdutos();
		for (Produto prod : produtos) {
			comboBox.addItem(prod);			
		}
		frameCadastroCliente.getContentPane().add(comboBox);
		
		btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String produtoNome = ((Produto) comboBox.getSelectedItem()).getNome();
				double produtoPreco = ((Produto) comboBox.getSelectedItem()).getPreco();
				String precoString = String.valueOf(produtoPreco);
				textFieldNome.setText(produtoNome);
				textFieldPreco.setText(precoString);
			}
		});
		btnOk.setBounds(373, 41, 65, 23);
		frameCadastroCliente.getContentPane().add(btnOk);
		
		lbMsg = new JLabel("");
		lbMsg.setBounds(35, 251, 394, 14);
		frameCadastroCliente.getContentPane().add(lbMsg);
		
		frameCadastroCliente.setVisible(true);
	}
}

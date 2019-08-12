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
import modelo.Servico;

import javax.swing.JComboBox;

public class TelaAtualizarServico {

	private JFrame frameCadastroCliente;
	private JTextField textFieldNome;
	private JTextField textFieldPreco;
	private JButton btnAtualizar;
	private JComboBox<Servico> comboBox;
	private JButton btnOk;
	private JLabel lbMsg;


	/**
	 * Create the application.
	 */
	public TelaAtualizarServico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCadastroCliente = new JFrame("Pet Shop - Atualizar servico");
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
						Fachada.atualizarServico(textFieldNome.getText(), preco);
						lbMsg.setText("Servico atualizado!");
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
		
		JLabel lblBuscarCliente = new JLabel("Servicos:");
		lblBuscarCliente.setBounds(49, 45, 95, 14);
		frameCadastroCliente.getContentPane().add(lblBuscarCliente);
		
		comboBox = new JComboBox<Servico>();
		comboBox.setBounds(115, 38, 248, 28);
		// adicionar produtos ao comboBox
		List<Servico> servicos = Fachada.todosServicos();
		for (Servico serv : servicos) {
			comboBox.addItem(serv);			
		}
		frameCadastroCliente.getContentPane().add(comboBox);
		
		btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String servicoNome = ((Servico) comboBox.getSelectedItem()).getNome();
				double servicoPreco = ((Servico) comboBox.getSelectedItem()).getPreco();
				String precoString = String.valueOf(servicoPreco);
				textFieldNome.setText(servicoNome);
				textFieldPreco.setText(precoString);
			}
		});
		btnOk.setBounds(373, 41, 65, 23);
		frameCadastroCliente.getContentPane().add(btnOk);
		
		lbMsg = new JLabel("");
		lbMsg.setBounds(46, 250, 392, 14);
		frameCadastroCliente.getContentPane().add(lbMsg);
		
		frameCadastroCliente.setVisible(true);
	}
}

package aplicacaoSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Cliente;

public class TelaAtualizarCliente {

	private JFrame frameCadastroCliente;
	private JTextField textFieldNome;
	private JTextField textFieldEndereco;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JButton btnAtualizar;
	private JTextField textFieldBusca;
	private JLabel lbMsg;


	/**
	 * Create the application.
	 */
	public TelaAtualizarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCadastroCliente = new JFrame("Pet Shop - Atualizar cliente");
		frameCadastroCliente.setBounds(600, 350, 500, 430);
		frameCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastroCliente.getContentPane().setLayout(null);
		
		
		JLabel lblNome = new JLabel("* Nome:");
		lblNome.setBounds(46, 98, 82, 14);
		frameCadastroCliente.getContentPane().add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(45, 143, 82, 14);
		frameCadastroCliente.getContentPane().add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("*  Telefone:");
		lblTelefone.setBounds(45, 187, 79, 14);
		frameCadastroCliente.getContentPane().add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(45, 234, 46, 14);
		frameCadastroCliente.getContentPane().add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(115, 91, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(114, 136, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldEndereco);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(114, 180, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(114, 227, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldEmail);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNome.getText().isEmpty() && textFieldEndereco.getText().isEmpty() && textFieldTelefone.getText().isEmpty() && textFieldEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				} else {
					try {
						Fachada.atualizarCliente(textFieldNome.getText(), textFieldTelefone.getText(), textFieldEmail.getText(), textFieldEndereco.getText());
						lbMsg.setText("Cliente Atualizado!");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				textFieldNome.setText("");
				textFieldTelefone.setText("");
				textFieldEmail.setText("");
				textFieldEndereco.setText("");
				textFieldBusca.setText("");
			}
		});
		btnAtualizar.setBounds(184, 316, 119, 41);
		frameCadastroCliente.getContentPane().add(btnAtualizar);
		
		JLabel lblBuscarCliente = new JLabel("Buscar cliente:");
		lblBuscarCliente.setBounds(30, 45, 95, 14);
		frameCadastroCliente.getContentPane().add(lblBuscarCliente);
		
		textFieldBusca = new JTextField();
		textFieldBusca.setBounds(116, 38, 187, 28);
		frameCadastroCliente.getContentPane().add(textFieldBusca);
		textFieldBusca.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = Fachada.consultarClientePorNomeObj(textFieldBusca.getText());
					textFieldNome.setText(cliente.getNome());
					textFieldTelefone.setText(cliente.getTelefone());
					textFieldEmail.setText(cliente.getEmail());
					textFieldEndereco.setText(cliente.getEndereco());
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(340, 37, 89, 23);
		frameCadastroCliente.getContentPane().add(btnNewButton);
		
		lbMsg = new JLabel("");
		lbMsg.setBounds(38, 284, 392, 14);
		frameCadastroCliente.getContentPane().add(lbMsg);
		
		frameCadastroCliente.setVisible(true);
	}
}

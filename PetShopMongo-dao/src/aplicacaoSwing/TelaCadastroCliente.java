package aplicacaoSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fachada.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente {

	private JFrame frameCadastroCliente;
	private JTextField textFieldNome;
	private JTextField textFieldEndereco;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JButton btnAdicionarAnimal;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCadastroCliente = new JFrame("Pet Shop - Cadastro cliente");
		frameCadastroCliente.setBounds(600, 350, 500, 430);
		frameCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastroCliente.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("* Nome:");
		lblNome.setBounds(51, 64, 82, 14);
		frameCadastroCliente.getContentPane().add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(51, 112, 82, 14);
		frameCadastroCliente.getContentPane().add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("*  Telefone:");
		lblTelefone.setBounds(51, 156, 79, 14);
		frameCadastroCliente.getContentPane().add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(51, 203, 46, 14);
		frameCadastroCliente.getContentPane().add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(120, 57, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(120, 105, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldEndereco);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(120, 149, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(120, 196, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldEmail);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNome.getText().isEmpty() && textFieldEndereco.getText().isEmpty() && textFieldTelefone.getText().isEmpty() && textFieldEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione pelo menos os campos nome e telefone!");
				} else {
					if (textFieldEndereco.getText().isEmpty() && textFieldEmail.getText().isEmpty()) {
						try { 
							Fachada.cadastrarCliente(textFieldNome.getText(), textFieldTelefone.getText());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}	
					} else {
						
						try { 
							Fachada.cadastrarCliente(textFieldNome.getText(), textFieldEndereco.getText(), textFieldTelefone.getText(), textFieldEmail.getText());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}				
					}
					textFieldNome.setText("");
					textFieldTelefone.setText("");
					textFieldEmail.setText("");
					textFieldEndereco.setText("");
					btnAdicionarAnimal.setEnabled(true);
				}
			}
		});
		btnCadastrar.setBounds(180, 271, 119, 41);
		frameCadastroCliente.getContentPane().add(btnCadastrar);
		
		btnAdicionarAnimal = new JButton("Adicionar animal");
		btnAdicionarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameCadastroCliente.dispose();
				TelaCadastroAnimal telaCadAnimal = new TelaCadastroAnimal();
				
			}
		});
		
		btnAdicionarAnimal.setBounds(180, 334, 119, 41);
		btnAdicionarAnimal.setEnabled(false);
		frameCadastroCliente.getContentPane().add(btnAdicionarAnimal);
		
		frameCadastroCliente.setVisible(true);
	}
}

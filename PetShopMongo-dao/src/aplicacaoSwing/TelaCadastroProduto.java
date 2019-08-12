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

public class TelaCadastroProduto {

	private JFrame frameCadastroCliente;
	private JTextField textFieldNome;
	private JTextField textFieldPreco;
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
	public TelaCadastroProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCadastroCliente = new JFrame("Pet Shop - Cadastro produto");
		frameCadastroCliente.setBounds(600, 350, 500, 430);
		frameCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastroCliente.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("* Nome:");
		lblNome.setBounds(51, 64, 82, 14);
		frameCadastroCliente.getContentPane().add(lblNome);
		
		JLabel lblPreco = new JLabel("* Preco:");
		lblPreco.setBounds(51, 112, 82, 14);
		frameCadastroCliente.getContentPane().add(lblPreco);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(120, 57, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
		textFieldPreco.setBounds(120, 105, 133, 28);
		frameCadastroCliente.getContentPane().add(textFieldPreco);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNome.getText().isEmpty() && textFieldPreco.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				} else {
					double preco = Double.parseDouble(textFieldPreco.getText());
					try {
						Fachada.cadastrarProduto(textFieldNome.getText(), preco);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				textFieldNome.setText("");
				textFieldPreco.setText("");
				}
		});
		btnCadastrar.setBounds(180, 271, 119, 41);
		frameCadastroCliente.getContentPane().add(btnCadastrar);
		
		frameCadastroCliente.setVisible(true);
	}
}

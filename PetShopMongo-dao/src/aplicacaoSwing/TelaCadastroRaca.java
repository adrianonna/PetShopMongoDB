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

public class TelaCadastroRaca {

	private JFrame frameCadastroCliente;
	private JTextField textFieldNome;
	private JTextField textFieldTamanho;
	private JTextField textFieldEspecie;
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
	public TelaCadastroRaca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCadastroCliente = new JFrame("Pet Shop - Cadastro raca");
		frameCadastroCliente.setBounds(600, 350, 500, 430);
		frameCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastroCliente.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("* Nome:");
		lblNome.setBounds(51, 64, 82, 14);
		frameCadastroCliente.getContentPane().add(lblNome);
		
		JLabel lblEndereco = new JLabel("* Tamanho:");
		lblEndereco.setBounds(51, 112, 82, 14);
		frameCadastroCliente.getContentPane().add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("*  Especie:");
		lblTelefone.setBounds(51, 156, 79, 14);
		frameCadastroCliente.getContentPane().add(lblTelefone);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(120, 57, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTamanho = new JTextField();
		textFieldTamanho.setColumns(10);
		textFieldTamanho.setBounds(120, 105, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldTamanho);
		
		textFieldEspecie = new JTextField();
		textFieldEspecie.setColumns(10);
		textFieldEspecie.setBounds(120, 149, 314, 28);
		frameCadastroCliente.getContentPane().add(textFieldEspecie);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNome.getText().isEmpty() && textFieldTamanho.getText().isEmpty() && textFieldEspecie.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione pelo menos os campos nome e telefone!");
				} else {
				
					try { 
						Fachada.cadastrarRaca(textFieldNome.getText(), textFieldTamanho.getText(), textFieldEspecie.getText());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}				
				}
				textFieldNome.setText("");
				textFieldEspecie.setText("");
				textFieldTamanho.setText("");
				}
		});
		btnCadastrar.setBounds(180, 271, 119, 41);
		frameCadastroCliente.getContentPane().add(btnCadastrar);
		
		frameCadastroCliente.setVisible(true);
	}
}

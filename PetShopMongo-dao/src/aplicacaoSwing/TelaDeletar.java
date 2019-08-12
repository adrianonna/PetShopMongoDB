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
import javax.swing.JComboBox;

public class TelaDeletar {

	private JFrame frameCadastroCliente;
	private JTextField textFieldNome;
	private JButton btnDeletar;
	private JComboBox<String> comboBoxTipo;


	/**
	 * Create the application.
	 */
	public TelaDeletar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCadastroCliente = new JFrame("Pet Shop - deletar");
		frameCadastroCliente.setBounds(600, 350, 500, 430);
		frameCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastroCliente.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("* Nome:");
		lblNome.setBounds(51, 64, 82, 14);
		frameCadastroCliente.getContentPane().add(lblNome);
		
		JLabel lblTipo = new JLabel("* Tipo:");
		lblTipo.setBounds(51, 112, 82, 14);
		frameCadastroCliente.getContentPane().add(lblTipo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(120, 57, 250, 28);
		frameCadastroCliente.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNome.getText().isEmpty() || comboBoxTipo.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Escreva um nome e o que deseja excluir");
				} else {
					String msg = "";
					try {
						switch (comboBoxTipo.getSelectedIndex()) {
						case 1:
							msg = Fachada.excluirCliente(textFieldNome.getText());						
							break;
						case 2:
							msg = Fachada.excluirProduto(textFieldNome.getText());
							break;
						case 3:
							msg = Fachada.excluirServico(textFieldNome.getText());
							break;
						default:
							break;
						}						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());					
					}
					JOptionPane.showMessageDialog(null, msg);
					textFieldNome.setText("");
					comboBoxTipo.setSelectedIndex(0);
				}
			}
		});
		btnDeletar.setBounds(168, 257, 119, 41);
		frameCadastroCliente.getContentPane().add(btnDeletar);
		
		comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setBounds(120, 109, 250, 28);
		comboBoxTipo.addItem("Escolha um item...");
		comboBoxTipo.addItem("Cliente");
		comboBoxTipo.addItem("Produto");
		comboBoxTipo.addItem("Servico");
		frameCadastroCliente.getContentPane().add(comboBoxTipo);
		
		frameCadastroCliente.setVisible(true);
	}
}

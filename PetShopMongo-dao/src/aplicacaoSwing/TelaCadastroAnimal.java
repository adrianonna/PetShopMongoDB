package aplicacaoSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Raca;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaCadastroAnimal {

	private JFrame frameCadastroCliente;
	private JTextField textFieldNome;
	private JButton btnCadastrar;
	private JTextField textFieldData;
	private JTextField textFieldPeso;
	private JLabel lblCliente;
	private JTextField textFieldCliente;
	private JTextField textFieldCompri;
	private JLabel lblRaca;
	private JComboBox<String> comboBoxRaca;
	private JComboBox<String> comboBoxSexo;

	/**
	 * Create the application.
	 */
	public TelaCadastroAnimal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCadastroCliente = new JFrame("Pet Shop - Cadastro Animal");
		frameCadastroCliente.setBounds(600, 350, 500, 430);
		frameCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastroCliente.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("* Nome:");
		lblNome.setBounds(10, 64, 82, 14);
		frameCadastroCliente.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(100, 61, 125, 20);
		frameCadastroCliente.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNome.getText().isEmpty() && textFieldPeso.getText().isEmpty() && textFieldCompri.getText().isEmpty() && textFieldData.getText().isEmpty() && comboBoxSexo.getSelectedIndex() == 0  && comboBoxRaca.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Adicione pelo menos os campos nome, raca e cliente!");

				} else {
					if (textFieldPeso.getText().isEmpty() && textFieldCompri.getText().isEmpty() && textFieldData.getText().isEmpty() && comboBoxSexo.getSelectedIndex() == 0) {
						try {
							Fachada.cadastrarAnimal(textFieldNome.getText(), comboBoxRaca.getSelectedItem().toString());
							Fachada.adicionarAnimalDoCliente(textFieldNome.getText(), textFieldCliente.getText());
							
							limparCampos();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					} else {
						double peso = Double.parseDouble(textFieldPeso.getText());
						double compri = Double.parseDouble(textFieldCompri.getText());
						try {
							DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date data = (Date)formatter.parse(textFieldData.getText());
							// vou passar a raca como string
							Fachada.cadastrarAnimal(textFieldNome.getText(), data , comboBoxRaca.getSelectedItem().toString(), peso, compri, comboBoxRaca.getSelectedItem().toString());
							Fachada.adicionarAnimalDoCliente(textFieldNome.getText(), textFieldCliente.getText());
							
							limparCampos();

						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}				
					}
					
				}
				
			}
		});
		btnCadastrar.setBounds(180, 271, 119, 41);
		frameCadastroCliente.getContentPane().add(btnCadastrar);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 105, 46, 14);
		frameCadastroCliente.getContentPane().add(lblSexo);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(246, 105, 101, 14);
		frameCadastroCliente.getContentPane().add(lblDataNascimento);
		
		textFieldData = new JTextField("00/00/0000");
		textFieldData.setColumns(10);
		textFieldData.setBounds(343, 102, 101, 20);
		frameCadastroCliente.getContentPane().add(textFieldData);
		
		textFieldPeso = new JTextField("0");
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(314, 140, 130, 20);
		frameCadastroCliente.getContentPane().add(textFieldPeso);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(246, 143, 46, 14);
		frameCadastroCliente.getContentPane().add(lblPeso);
		
		JLabel lblComprimento = new JLabel("Comprimento:");
		lblComprimento.setBounds(10, 143, 110, 14);
		frameCadastroCliente.getContentPane().add(lblComprimento);
		
		lblCliente = new JLabel("* Cliente:");
		lblCliente.setBounds(246, 67, 101, 14);
		frameCadastroCliente.getContentPane().add(lblCliente);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setColumns(10);
		textFieldCliente.setBounds(314, 64, 130, 20);
		frameCadastroCliente.getContentPane().add(textFieldCliente);
		
		textFieldCompri = new JTextField("0");
		textFieldCompri.setColumns(10);
		textFieldCompri.setBounds(100, 140, 125, 20);
		frameCadastroCliente.getContentPane().add(textFieldCompri);
		
		lblRaca = new JLabel("* Raca");
		lblRaca.setBounds(32, 199, 46, 14);
		frameCadastroCliente.getContentPane().add(lblRaca);
		
		comboBoxRaca = new JComboBox<String>();
		comboBoxRaca.setBounds(100, 196, 192, 20);
		comboBoxRaca.addItem("Escolha uma raca...");
		// adicionar racas ao combox
		List<Raca> racas = Fachada.todasRacas();
		for (Raca raca : racas) {
			comboBoxRaca.addItem(raca.getDescricao());			
		}
		frameCadastroCliente.getContentPane().add(comboBoxRaca);
		
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setBounds(100, 102, 125, 20);
		frameCadastroCliente.getContentPane().add(comboBoxSexo);
		comboBoxSexo.addItem("Escolha um sexo...");
		comboBoxSexo.addItem("Feminino");
		comboBoxSexo.addItem("Masculino");
		
		frameCadastroCliente.setVisible(true);
	}
	public void limparCampos() {
		textFieldNome.setText("");
		textFieldPeso.setText("");
		textFieldCompri.setText("");
		textFieldData.setText("");
		textFieldCliente.setText("");
		
		comboBoxRaca.setSelectedIndex(0);
		comboBoxSexo.setSelectedIndex(0);

	}
}

package aplicacaoSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

public class TelaConsultas extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnClienteNome;
	private JButton btnListarAnimais;
	private JButton btnListarServicos;
	private JButton btnAnimaisCliente;
	private JButton btnLstAtend;
	private JButton btnLstRacas;

	/**
	 * Create the frame.
	 */
	public TelaConsultas() {
		setTitle("Pet Shop - Consultas");
		//setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 350, 623, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnClienteNome = new JButton("Cliente por nome");
		btnClienteNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nom = JOptionPane.showInputDialog("digite parte do nome");
					textArea.setText(Fachada.consultarClientePorParteNome(nom));
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnClienteNome.setBounds(10, 380, 178, 30);
		contentPane.add(btnClienteNome);

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 548, 340);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);

		btnListarAnimais = new JButton("Total atendimento");
		btnListarAnimais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String num = JOptionPane.showInputDialog("digite id de atendimento");
					int id = Integer.parseInt(num);
					textArea.setText(Fachada.consultarValorAtendimento(id));
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnListarAnimais.setBounds(200, 380, 183, 30);
		contentPane.add(btnListarAnimais);
		
		btnListarServicos = new JButton("Servicos-Produtos");
		btnListarServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nom = JOptionPane.showInputDialog("digite o servico ou produto");
					textArea.setText(Fachada.consultarClientesPorServicoOuProduto(nom));
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnListarServicos.setBounds(408, 380, 164, 30);
		contentPane.add(btnListarServicos);
		
		btnAnimaisCliente = new JButton("Animais cliente");
		btnAnimaisCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String cli = JOptionPane.showInputDialog("digite nome do cliente");
					textArea.setText(Fachada.consultarAnimaisDoCliente(cli));
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnAnimaisCliente.setBounds(10, 421, 178, 30);
		contentPane.add(btnAnimaisCliente);
		
		btnLstAtend = new JButton("Maior consumo");
		btnLstAtend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(Fachada.consultarAtendimentoMaisConsumiu());
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnLstAtend.setBounds(200, 421, 183, 30);
		contentPane.add(btnLstAtend);
		
		btnLstRacas = new JButton("Servico do animal");
		btnLstRacas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ani = JOptionPane.showInputDialog("digite o nome do animal");
					textArea.setText(Fachada.consultarServicoAnimal(ani));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnLstRacas.setBounds(408, 421, 165, 30);
		contentPane.add(btnLstRacas);
		
	}
}

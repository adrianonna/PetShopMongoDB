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

public class TelaListagem extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnListarClientes;
	private JButton btnListarAnimais;
	private JButton btnListarServicos;
	private JButton btnListarProdutos;
	private JButton btnLstAtend;
	private JButton btnLstRacas;

	/**
	 * Create the frame.
	 */
	public TelaListagem() {
		setTitle("Pet Shop - Listagens");
		//setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 350, 623, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

					textArea.setText(Fachada.listarClientes());
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnListarClientes.setBounds(34, 380, 150, 30);
		contentPane.add(btnListarClientes);

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 548, 340);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);

		btnListarAnimais = new JButton("Listar Animais");
		btnListarAnimais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{

					textArea.setText(Fachada.listarAnimais());
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnListarAnimais.setBounds(223, 380, 150, 30);
		contentPane.add(btnListarAnimais);
		
		btnListarServicos = new JButton("Listar Servicos");
		btnListarServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(Fachada.listarServicos());
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnListarServicos.setBounds(433, 380, 150, 30);
		contentPane.add(btnListarServicos);
		
		btnListarProdutos = new JButton("Listar Produtos");
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(Fachada.listarProdutos());
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnListarProdutos.setBounds(34, 421, 150, 30);
		contentPane.add(btnListarProdutos);
		
		btnLstAtend = new JButton("Listar Atendimentos");
		btnLstAtend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(Fachada.listarAtendimento());
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnLstAtend.setBounds(223, 421, 150, 30);
		contentPane.add(btnLstAtend);
		
		btnLstRacas = new JButton("Listar Racas");
		btnLstRacas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(Fachada.listarRaca());
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnLstRacas.setBounds(433, 421, 150, 30);
		contentPane.add(btnLstRacas);
		
	}
}

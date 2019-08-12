
package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Animal;
import modelo.Atendimento;
import modelo.Cliente;
import modelo.Servico;
import modelo.Produto;
import modelo.Raca;


public class DAOAtendimento extends DAO<Atendimento>{
	//Leitura POR id 
	public Atendimento read (Object chave) {
		try {
			Integer id = (Integer) chave;
			Query q = manager.createQuery("select c from Atendimento c where c.id= "+ id + "");
			return (Atendimento) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public List<Atendimento> readAll () {
		try {
			Query q = manager.createQuery("select a from Atendimento a");
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	// CONSULTAS 
	
	public String consultarRacaConsumiuProduto(String nomeProduto, String nomeServico) {
		Query q = manager.createQuery("SELECT a FROM Atendimento a JOIN a.produtos prod JOIN a.servicos serv WHERE prod.nome = '"+nomeProduto+"' AND serv.nome = '" + nomeServico + "'");
		List<Atendimento> resultados = q.getResultList();
		String texto = "";
		for (Atendimento atendimento : resultados) {
			texto += atendimento.getAnimal().getRaca().getDescricao() + " | ";
		}
		return ""+ texto;
	}
	
	
//	public String consultarRacaConsumiuProduto(String nomeProduto, String nomeServico) {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.descend("produtos").descend("nome").constrain(nomeProduto);
//		q.descend("servicos").descend("nome").constrain(nomeServico);
//		List<Atendimento> resultados = q.execute();
//		String texto = "";
//		for (Atendimento atendimento : resultados) {
//			texto += atendimento.getAnimal().getRaca().getDescricao() + " | ";
//		}
//		return ""+ texto;
//	}
//
//	
//	
//	public ArrayList<Cliente> consultarClientesPorProduto(String nome) {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.descend("produtos").descend("nome").constrain(nome);
//		List<Atendimento> resultados = q.execute();
//		ArrayList<Cliente> clientes = new ArrayList<>();
//		for(Atendimento aten : resultados) {
//			clientes.add(aten.getAnimal().getCliente()); 
//		}
//		return clientes;
//	}
//	

	
	public double consultarValorAtendimento(int id) {
		Query q = manager.createQuery("SELECT a FROM Atendimento a WHERE a.id = '"+id+"'");
		Atendimento resultado = (Atendimento) q.getSingleResult();
		return resultado.getPrecoTotal();
	}
	
	public Atendimento consultarAtendimentoMaisConsumiu() {
		Query q = manager.createQuery("SELECT max(a.precoTotal) FROM Atendimento a");
		Double resultado = (Double) q.getSingleResult();
		Query qq = manager.createQuery("SELECT a FROM Atendimento a where a.precoTotal = "+resultado);
		return (Atendimento) qq.getSingleResult();
	}
	
//	public ArrayList<Cliente> consultarClientesPorServico(String nome) {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.descend("servicos").descend("nome").constrain(nome);
//		List<Atendimento> resultados = q.execute();
//		ArrayList<Cliente> clientes = new ArrayList();
//		for(Atendimento aten : resultados) {
//			clientes.add(aten.getAnimal().getCliente()); 
//		}
//		return clientes;
//	}
//	
//	public List<Atendimento> consultarClientesPorServicoEProduto(String serv, String prod) {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.descend("servicos").descend("nome").constrain(serv);
//		q.descend("produtos").descend("nome").constrain(prod);
//		List<Atendimento> resultados = q.execute();
//		return resultados;
//	}
//		
//	public int consultarUltimoAtendimento() {
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		List<Atendimento> resultados = q.execute();	
//		if (resultados.size()>0)
//			return resultados.get(resultados.size()-1).getCod();
//		else
//			return 0;
//	}
//	
//	public List<Atendimento> consultarAtendimentoQuantidadeProdutos(int qtd){
//		Query q = manager.query();
//		q.constrain(Atendimento.class);
//		q.constrain(new Filtro(qtd));
//		List<Atendimento> result = q.execute();
//		return result;
//
//	}

	
}

//@SuppressWarnings("serial")
//class Filtro  implements Evaluation {
//	private int n;
//	public Filtro (int n) {this.n=n;}
//	public void evaluate(Candidate candidate) {
//		Atendimento aten = (Atendimento) candidate.getObject();
//		candidate.include(aten.getProdutos().size() >= n);
//	}
//}

package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Animal;
import modelo.Atendimento;
import modelo.Cliente;
import modelo.Produto;
import modelo.Raca;
import modelo.Servico;

public class DAOServico extends DAO<Servico>{
	//Leitura POR nome 
	public Servico read (Object chave) {
		try {
			String nome = (String) chave;
			Query q = manager.createQuery("select c from Servico c where c.nome= '"+ nome + "'");
			return (Servico) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Servico> readAll () {
		try {
			Query q = manager.createQuery("select c from Servico c");
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	
	public List<Servico> consultarServicoAnimal(String nomeAnimal) {
		Query q = manager.createQuery("SELECT distinct a.servicos FROM Atendimento a join a.servicos serv join a.animal ani where ani.nome = '"+ nomeAnimal +"'");
		return (List<Servico>) q.getResultList();
	}
	
	
//	
//	// por parte do nome
//	public  List<Servico> consultarServicoPorParteNome(String nome) {
//		Query q = manager.query();
//		q.constrain(Servico.class);
//		q.descend("nome").constrain(nome).like();
//		List<Servico> result = q.execute(); 
//		return result;
//	}
}


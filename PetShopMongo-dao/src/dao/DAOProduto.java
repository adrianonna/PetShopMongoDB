package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Atendimento;
import modelo.Cliente;
import modelo.Produto;
import modelo.Raca;
import modelo.Servico;

public class DAOProduto extends DAO<Produto>{
	//Leitura POR nome 
	public Produto read (Object chave) {
		try {
			String nome = (String) chave;
			Query q = manager.createQuery("select c from Produto c where c.nome= '"+ nome + "'");
			return (Produto) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public List<Produto> readAll () {
		try {
			Query q = manager.createQuery("select p from Produto p");
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
//	// por parte do nome
//		public List<Produto> consultarProdutoPorParteNome(String nome) {
//			Query q = manager.query();
//			q.constrain(Produto.class);
//			q.descend("nome").constrain(nome).like();
//			List<Produto> result = q.execute(); 
//			return result;
//		}
//
//		public int consultarUltimoIdProduto() {
//			Query q = manager.query();
//			q.constrain(Produto.class);
//			List<Produto> resultados = q.execute();	
//			if (resultados.size()>0) 
//				return resultados.get(resultados.size()-1).getId();
//			else
//				return 0;
//		}
//		
}


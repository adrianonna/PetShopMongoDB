package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fachada.Fachada;
import modelo.Animal;
import modelo.Atendimento;
import modelo.Cliente;
import modelo.Produto;
import modelo.Raca;
import modelo.Servico;


public class DAOCliente  extends DAO<Cliente> {
	//Leitura POR nome 
	public Cliente read (Object chave) {
		try {
			String nome = (String) chave;
			Query q = manager.createQuery("select c from Cliente c where c.nome= '"+ nome + "'");
			return (Cliente) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	
	public List<Cliente> readAll () {
		try {
			Query q = manager.createQuery("select c from Cliente c");
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	//CONSULTAS
	
	public ArrayList<Cliente> consultarClientesQueTenhamCompradoProdutoEServico(String nomeProd, String nomeServ) {
		Query q = manager.createQuery("SELECT c FROM Cliente c JOIN c.animais ani JOIN ani.atendimentos aten JOIN aten.produtos prod JOIN aten.servicos serv WHERE prod.nome = '"+ nomeProd +"' AND serv.nome = '" + nomeServ +  "'");
		System.out.println(q.getResultList());
		return (ArrayList<Cliente>) q.getResultList();
	}
	
	
	public ArrayList<Cliente> consultarClientesPorServicoOuProduto(String nome) {
		Query q = manager.createQuery("SELECT distinct c FROM Cliente c join c.animais ani JOIN ani.atendimentos aten JOIN aten.produtos prod JOIN aten.servicos serv WHERE prod.nome = '"+ nome +"' OR serv.nome = '" + nome +  "'");
		System.out.println(q.getResultList());
		return (ArrayList<Cliente>) q.getResultList();
	}
	
	
	public ArrayList<Cliente> consultarClientePorParteNome(String nome) {
			try {
				Query q = manager.createQuery("select c from Cliente c where c.nome like '%"+ nome + "%'");
				return (ArrayList<Cliente>) q.getResultList();
			} catch (NoResultException e) {
				return null;
			}
	}
	
//	public String consultarClientePorNome(String nome) {
//		Query q = manager.createQuery("select c from Cliente c where c.nome = '"+ nome + "'");
//		return (String) q.getSingleResult();
//		return "\nConsultar cliente -  nao encontrado";
//	}
	
	public  Cliente consultarClientePorNomeObj(String nome) throws  Exception {
			try {
				Query q = manager.createQuery("select c from Cliente c where c.nome= '"+ nome + "'");
				return (Cliente) q.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
	}
	
	public Cliente consultarClientePorTelefone(String n) throws  Exception {
		try {
			String telefone = (String) n;
			Query q = manager.createQuery("select c from Cliente c where c.telefone= '"+ telefone + "'");
			return (Cliente) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
//	
	public ArrayList<Animal> consultarAnimaisDoCliente(String nomeCliente) {
		Query q = manager.createQuery("select a from Animal a "
									+ "join Cliente c on c.id = a.cliente.id "
									+ "where c.nome= '"+ nomeCliente + "'");
		return (ArrayList<Animal>) q.getResultList();
	}
//		
//	public int consultarTotalClientes() {
//		Query q = manager.query();
//		q.constrain(Cliente.class);
//		int total = q.execute().size(); 
//		return total;
//	}
//	
//	public List<Animal> consultaAnimalPorCliente(String cli) {
//		Query q = manager.query();
//		q.constrain(Animal.class);
//		q.descend("c").constrain(cli); 
//		List<Animal> result = q.execute(); 
//		return result;
//	}
//	
//	public int consultarUltimoIdCliente() {
//		Query q = manager.query();
//		q.constrain(Cliente.class);
//		List<Cliente> resultados = q.execute();	
//		if (resultados.size()>0) 
//			return resultados.get(resultados.size()-1).getId();
//		else
//			return 0;
//	}

}

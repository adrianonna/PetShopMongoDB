package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Animal;
import modelo.Atendimento;
import modelo.Cliente;
import modelo.Raca;


public class DAOAnimal extends DAO<Animal>{
	//Leitura POR nome 
	public Animal read (Object chave) {
		try {
			String nome = (String) chave;
			Query q = manager.createQuery("select c from Animal c where c.nome= '"+ nome + "'");
			return (Animal) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	
	public List<Animal> readAll () {
		try {
			Query q = manager.createQuery("select a from Animal a");
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}



	//CONSULTAS	

//	public int consultarUltimoIdAnimal() {
//		Query q = manager.query();
//		q.constrain(Animal.class);
//		List<Animal> resultados = q.execute();	
//		if (resultados.size()>0) 
//			return resultados.get(resultados.size()-1).getCod();
//		else 
//			return 0;
//	}
//
//	public String consultarDonoERacaAnimal(String nomeAnimal) {
//		Query q = manager.query();
//		q.constrain(Animal.class);
//		q.descend("nome").constrain(nomeAnimal);
//		List<Animal> resultados = q.execute();
//		if (resultados.size() > 0)
//			return "cliente: " + resultados.get(0).getCliente().getNome() + " | possui animal raca: " + resultados.get(0).getRaca().getDescricao();
//		return "não encontrado";
//	}


}
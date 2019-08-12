package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.eclipse.persistence.annotations.Index;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import modelo.Atendimento;

@Entity
@Index(name="CLI_IND", columnNames= {"nome", "email"})
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Cliente {
	
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	
	@OneToMany(mappedBy="cliente")
	private List<Animal> animais = new ArrayList<>();
		

	public Cliente(String nome, String endereco, String telefone, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Cliente(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public Cliente() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Animal> getAnimais() {
		return this.animais;
	}

	public void setAnimal(Animal animal) {
		this.animais.add(animal);
	}
	

	public Cliente Filtro() {
		return null;
	}
	
	public Object localizarAnimal(String nomeAnimal) {
		for(Animal i : this.animais) {
			if (i.getNome() == nomeAnimal) {
				return i;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", email="
				+ email + " animais: " + this.getAnimais() + "]";
	}


	
	
	
}

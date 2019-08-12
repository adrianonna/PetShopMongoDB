package modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity 
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Raca {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String tamanho;
	private String especie;
	
	@OneToMany(mappedBy="raca")
	private List<Animal> animais;
	
	public Raca(String nome, String tamanho, String especie) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.especie = especie; //tipo do animal, gato, cachorro
	}
	
	public Raca(String nome, String especie) {
		this.nome = nome;
		this.especie = especie; //tipo do animal, gato, cachorro
	}
	
	public Raca() {
		
	}
	
	public String getDescricao() {
		return nome;
	}
	public void setDescricao(String nome) {
		this.nome = nome;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Raca [descricao=" + nome + ", tamanho=" + tamanho + ", especie=" + especie + "]";
	}
	
	
	
	
	
	
}

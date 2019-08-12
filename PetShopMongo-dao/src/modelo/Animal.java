package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Index;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

import modelo.Raca;


@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Animal {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Index
	private String nome;
	private Date data_nasc;
	private String sexo;
	private Double peso;
	private Double comprimento;

	@ManyToOne
	private Raca raca;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy="animal", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Atendimento> atendimentos = new ArrayList<>();
	
	
	public Animal(String nome, Date data_nasc, String sexo, Double peso, Double comprimento, Raca raca) {
		this.nome = nome;
		this.data_nasc = data_nasc;
		this.sexo = sexo;
		this.peso = peso;
		this.comprimento = comprimento;
		this.raca = raca;
	}
	
	public Animal(String nome, Raca raca) {
		this.nome = nome;
		this.raca = raca;
	}
	
	public Animal() {}


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

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getComprimento() {
		return comprimento;
	}

	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}
	
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(Atendimento atendimento) {
		this.atendimentos.add(atendimento);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente c) {
		this.cliente = c;
	}


	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + ", data_nasc=" + data_nasc + ", sexo=" + sexo + 
				", peso="+ peso + ", comprimento=" + comprimento + ", raca=" + raca.getDescricao() +
				"]";
	}
	
	
	
}

package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Index;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity 
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Atendimento {
	
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Index
	private double precoTotal;
	private LocalDate data;
	private String funcionario;
	
	@ManyToOne
	private Animal animal;
	
	@ManyToMany(mappedBy="atendimentos", fetch=FetchType.LAZY)
	private List<Produto> produtos = new ArrayList<Produto>();
	
	@ManyToMany(mappedBy="atendimentos", fetch=FetchType.LAZY)
	private List<Servico> servicos = new ArrayList<Servico>();
	
	public Atendimento(LocalDate data, String funcionario) {
		this.data = data;
		this.funcionario = funcionario;
	}
	
	public Atendimento(LocalDate data, String funcionario, Animal animal) {
		this.data = data;
		this.funcionario = funcionario;
		this.animal = animal;
	}

	public Atendimento() {}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produto) {
		produtos.add(produto);
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Servico servico) {
		this.servicos.add(servico);
	}
	

	@Override
	public String toString() {
		return "Atendimento [id=" + id + ", Pre�oTotal: "+ precoTotal +", data=" + data + ", funcionario="
				+ funcionario + ", animal=" + this.getAnimal() + ", produtos=" + this.getProdutos() +
				", servicos=" + this.getServicos() + "]";
	}

//	@Override
//	public String toString() {
//		return "Atendimento [cod=" + cod + ", precoTotal=" + precoTotal + ", data=" + data + ", funcionario="
//				+ funcionario + ", produtos=" + this.getProdutos() + ", servicos=" + this.getServicos() + "]";
//	}
	
	


	

	
	

}

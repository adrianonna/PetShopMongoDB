package modelo;
/*
 * IFPB - POB - Fausto Ayres
 * Aplicação JPA + Mongodb
 */

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;


//@Embeddable
@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Item implements Serializable {
	@Id 
	@GeneratedValue
	@Field(name="_id")	//chave
	private String id;

	private int quantidade;
	private double preco;	
	private String descricao;
	@ManyToOne
	private Pedido pedido;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Item() {
	}

	public Item(int q, double p, String d, Pedido pe) {
		super();
		this.quantidade = q;
		this.preco = p;
		this.descricao = d;
		this.pedido = pe;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "  Item [quantidade=" + quantidade + ", preco=" + preco + ", "
				+ (descricao != null ? "descricao=" + descricao + ", " : "")
				+ (pedido != null ? "pedido=" + pedido.getCliente() : "") + "]";
	}


}

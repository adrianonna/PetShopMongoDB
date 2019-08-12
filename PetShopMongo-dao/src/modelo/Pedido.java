package modelo;
/*
 * IFPB - POB - Fausto Ayres
 * Aplicação JPA + Mongodb
 */

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;


@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Pedido implements Serializable {
	@Id 
	@GeneratedValue
	@Field(name="_id")		//chave
	private String id;
	@Temporal(TemporalType.DATE)
	private Date data;

	private String cliente;

	@OneToMany(cascade=CascadeType.ALL)
	private List<Item> itens = new ArrayList<>();	

	public Pedido() {}

	public Pedido(String cliente) {
		super();
		this.cliente = cliente;
		this.data = new Date();
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void adicionar(Item i) {
		itens.add(i);
	}
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String texto= "Pedido [" + (id != null ? "id=" + id + ", " : "") + 
					(data != null ? "data=" + f.format(data) + ", " : "")
				+ (cliente != null ? "cliente=" + cliente + ", " : "") ;
		for(Item it : itens)
			texto+="\n"+ it ;
		return texto;
	}


}

package com.deniswillian.cursomcc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.deniswillian.cursomcc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity //Criando Tabela PAGAMENTO no banco de Dados
@Inheritance(strategy=InheritanceType.JOINED) // Comando de Herança para as SubClasses PagamentoComBoleto e PagamentoComCartao com poucos atributos
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Pagamento implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	// Quando tem a cardinalidade de (1,1) entre as tabelas PAGAMENTO e PEDIDO, não precisa informar que Id(PK) tem que gerar código automático
	@Id
	private Integer id;
	private Integer estado;
	
	@JsonIgnore
	//Cardinalidade (1,1) entre PAGAMENTO E PEDIDO.
	@OneToOne//(1,1)
	@JoinColumn(name="pedido_id")// A chave primaria da tabela PAGAMENTO tem que ser a mesma da tabela PEDIDO
	@MapsId// Comando que confirma que as chaves PK das duas tabelas(PAGAMENTO e PEDIDO) sejam as mesmas. 
	private Pedido pedido;
	
	public Pagamento() {
	}

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = (estado==null) ? null : estado.getCod();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

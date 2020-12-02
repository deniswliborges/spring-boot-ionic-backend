package com.deniswillian.cursomcc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// 1- Criando Endpoint("Tabela")   7- Implementando o Serializable : Para ser gravados em arquivos
@Entity
public class Categoria implements Serializable{
	
		//8- Coloque o mouse em cima da linha 6 e selecione opção | Add default serial version ID 
		private static final long serialVersionUID = 1L;		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;// 2- Criando Atributos do Endpoint(tabela)
		private String nome;
	
	// 3- Criando os CONSTRUTORES. Obs: Não incluir coleções no construtor com parâmetros
	public Categoria() {
	}

	// 4- Criando construtores com ATRIBUTOS com botão direito clicar em 1-Source, 2-Constructor using Fields
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	// 5- Criando GET e SET
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

	//6- Gerar o HASCODE e EQUALs : Comparar/relacionar os objetos ou tabelas  por valor, ou seja, pela Chave Primaria (PK). Obs: Escolha o ID para relacionar as tabelas
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	//6.1- Gerar o HASCODE e EQUALs : Comparar/relacionar os objetos ou tabelas  por valor, ou seja, pela Chave Primaria (PK). Obs: Escolha o ID para relacionar as tabelas
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}

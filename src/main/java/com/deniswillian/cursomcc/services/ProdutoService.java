package com.deniswillian.cursomcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deniswillian.cursomcc.domain.Categoria;
import com.deniswillian.cursomcc.domain.Produto;
import com.deniswillian.cursomcc.repositories.ProdutoRepository;
import com.deniswillian.cursomcc.services.exceptions.ObjectNotFounfException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo2;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo2.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounfException(
				"Objeto não encontrado! Id: "+ id + ", Tipo: "+ Produto.class.getName()));
	}
	
}

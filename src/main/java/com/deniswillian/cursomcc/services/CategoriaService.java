package com.deniswillian.cursomcc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.deniswillian.cursomcc.domain.Categoria;
import com.deniswillian.cursomcc.dto.CategoriaDTO;
import com.deniswillian.cursomcc.repositories.CategoriaRepository;
import com.deniswillian.cursomcc.services.exceptions.DataIntegrityException;
import com.deniswillian.cursomcc.services.exceptions.ObjectNotFounfException;

//import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounfException(
				"Objeto não encontrado! Id: "+ id + ", Tipo: "+ Categoria.class.getName()));
	}
	
public Categoria insert(Categoria obj) {
	obj.setId(null);
	return repo.save(obj);
}

public Categoria update(Categoria obj) {
	find(obj.getId());
	return repo.save(obj);
}

public void delete(Integer id) {
	find(id);
	try {
	repo.deleteById(id);
	}
	catch(DataIntegrityViolationException e) {
		throw new DataIntegrityException("Não é possível excluir uma Categoria que possui Produtos!");
	}
}

public List<Categoria>findAll(){
return repo.findAll();	
}

// ERRO PORQUE SÓ BUSCA O PARÂMETRO PAGE, O RESTANTES DOS PARÂMETROS NÃO APARECEM NO POSTMAN - refazer AULA 38
public Page<Categoria> findPage(Integer page,Integer linesPerPage, String orderBy,String direction){
	PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
	return repo.findAll(pageRequest);
}

public Categoria fromDTO(CategoriaDTO objDto) {
	return new Categoria(objDto.getId(), objDto.getNome());
}

}

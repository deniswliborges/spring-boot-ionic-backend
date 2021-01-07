package com.deniswillian.cursomcc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deniswillian.cursomcc.domain.Cidade;
import com.deniswillian.cursomcc.repositories.CidadeRepository;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository repo;

	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}

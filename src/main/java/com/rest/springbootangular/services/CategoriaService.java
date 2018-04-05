package com.rest.springbootangular.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springbootangular.dao.CategoriaDAO;
import com.rest.springbootangular.domain.Categoria;
import com.rest.springbootangular.services.exceptions.ObjectNotFoundException;



@Service
public class CategoriaService {
	@Autowired
	private CategoriaDAO repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}

}
	

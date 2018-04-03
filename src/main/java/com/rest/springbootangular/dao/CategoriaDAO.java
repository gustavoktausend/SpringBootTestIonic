package com.rest.springbootangular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.springbootangular.domain.Categoria;

@Repository
public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{ 
	
	

}

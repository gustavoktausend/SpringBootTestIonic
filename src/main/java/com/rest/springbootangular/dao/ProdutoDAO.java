package com.rest.springbootangular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.springbootangular.domain.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Integer>{ 
	
	

}

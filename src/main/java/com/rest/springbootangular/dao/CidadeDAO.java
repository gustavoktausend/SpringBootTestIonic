package com.rest.springbootangular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.springbootangular.domain.Cidade;

@Repository
public interface CidadeDAO extends JpaRepository<Cidade, Integer>{ 
	
	

}

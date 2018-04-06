package com.rest.springbootangular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.springbootangular.domain.Endereco;

@Repository
public interface EnderecoDAO extends JpaRepository<Endereco, Integer>{ 
	
	

}

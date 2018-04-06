package com.rest.springbootangular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.springbootangular.domain.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer>{ 
	
	

}

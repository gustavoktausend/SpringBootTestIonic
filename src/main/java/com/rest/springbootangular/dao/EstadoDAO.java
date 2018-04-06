package com.rest.springbootangular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.springbootangular.domain.Estado;

@Repository
public interface EstadoDAO extends JpaRepository<Estado, Integer>{ 
	
	

}

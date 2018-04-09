package com.rest.springbootangular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.springbootangular.domain.Pedido;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Integer>{ 
	
	

}

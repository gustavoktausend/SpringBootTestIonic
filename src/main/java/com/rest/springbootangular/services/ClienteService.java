package com.rest.springbootangular.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springbootangular.dao.ClienteDAO;
import com.rest.springbootangular.domain.Cliente;
import com.rest.springbootangular.services.exceptions.ObjectNotFoundException;



@Service
public class ClienteService {
	@Autowired
	private ClienteDAO repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}

}
	

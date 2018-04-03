package com.rest.springbootangular.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springbootangular.domain.Produto;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Produto> listar() {
		
		List<Produto> lista = new ArrayList<>();
		
		return lista;
	}

}

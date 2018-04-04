package com.rest.springbootangular;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.springbootangular.dao.CategoriaDAO;
import com.rest.springbootangular.domain.Categoria;

@SpringBootApplication
public class SpringBootAngularRestApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaDAO categoriaDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularRestApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		categoriaDao.save(cat1);
		categoriaDao.save(cat2);
		
		
	}
}

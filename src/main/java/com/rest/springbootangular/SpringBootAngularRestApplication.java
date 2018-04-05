package com.rest.springbootangular;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.springbootangular.dao.CategoriaDAO;
import com.rest.springbootangular.dao.ProdutoDAO;
import com.rest.springbootangular.domain.Categoria;
import com.rest.springbootangular.domain.Produto;

@SpringBootApplication
public class SpringBootAngularRestApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaDAO categoriaDao;
	@Autowired
	private ProdutoDAO produtoDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularRestApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.0);
		Produto p2 = new Produto(null,"Impressora", 800.0);
		Produto p3 = new Produto(null,"Mouse", 80.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2 , p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaDao.saveAll(Arrays.asList(cat1,cat2));
		produtoDao.saveAll(Arrays.asList(p1,p2,p3));
		
	
		
		
	}
}

package com.rest.springbootangular;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.springbootangular.dao.CategoriaDAO;
import com.rest.springbootangular.dao.CidadeDAO;
import com.rest.springbootangular.dao.ClienteDAO;
import com.rest.springbootangular.dao.EnderecoDAO;
import com.rest.springbootangular.dao.EstadoDAO;
import com.rest.springbootangular.dao.ProdutoDAO;
import com.rest.springbootangular.domain.Categoria;
import com.rest.springbootangular.domain.Cidade;
import com.rest.springbootangular.domain.Cliente;
import com.rest.springbootangular.domain.Endereco;
import com.rest.springbootangular.domain.Estado;
import com.rest.springbootangular.domain.Produto;
import com.rest.springbootangular.domain.enums.TipoCliente;

@SpringBootApplication
public class SpringBootAngularRestApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaDAO categoriaDao;
	@Autowired
	private ProdutoDAO produtoDao;
	@Autowired
	private CidadeDAO cidadeDao;
	@Autowired
	private EstadoDAO estadoDao;
	@Autowired
	private EnderecoDAO enderecoDao;
	@Autowired
	private ClienteDAO clienteDao;
	
	
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
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia" ,est1);
		Cidade c2 = new Cidade(null,"São paulo" , est2);
		Cidade c3 = new Cidade(null,"Campinas" , est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoDao.saveAll(Arrays.asList(est1, est2));
		cidadeDao.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("33333333","222222"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300","Ap303", "Jardim", "38220834", cli1,c1 );
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "centro", "38777012", cli1, c2);
		

		clienteDao.saveAll(Arrays.asList(cli1));
		enderecoDao.saveAll(Arrays.asList(e1,e2));
		
		
	}
}

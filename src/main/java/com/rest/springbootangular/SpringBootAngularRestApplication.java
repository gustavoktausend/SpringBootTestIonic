package com.rest.springbootangular;

import java.text.SimpleDateFormat;
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
import com.rest.springbootangular.dao.ItemPedidoDAO;
import com.rest.springbootangular.dao.PagamentoDAO;
import com.rest.springbootangular.dao.PedidoDAO;
import com.rest.springbootangular.dao.ProdutoDAO;
import com.rest.springbootangular.domain.Categoria;
import com.rest.springbootangular.domain.Cidade;
import com.rest.springbootangular.domain.Cliente;
import com.rest.springbootangular.domain.Endereco;
import com.rest.springbootangular.domain.Estado;
import com.rest.springbootangular.domain.ItemPedido;
import com.rest.springbootangular.domain.Pagamento;
import com.rest.springbootangular.domain.PagamentoComBoleto;
import com.rest.springbootangular.domain.PagamentoComCartao;
import com.rest.springbootangular.domain.Pedido;
import com.rest.springbootangular.domain.Produto;
import com.rest.springbootangular.domain.enums.EstadoPagamento;
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
	@Autowired
	private PedidoDAO pedidoDao;
	@Autowired
	private PagamentoDAO pagamentoDao;
	@Autowired
	private ItemPedidoDAO itemPedidoDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularRestApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		Categoria cat3 = new Categoria(null,"Cama Mesa e Banho");
		Categoria cat4 = new Categoria(null,"Eletrônicos");
		Categoria cat5 = new Categoria(null,"Jardinagem");
		Categoria cat6 = new Categoria(null,"Decoração");
		Categoria cat7 = new Categoria(null,"Perfumaria");
		
		
		Produto p1 = new Produto(null,"Computador",2000.0);
		Produto p2 = new Produto(null,"Impressora", 800.0);
		Produto p3 = new Produto(null,"Mouse", 80.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2 , p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaDao.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
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
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		

		clienteDao.saveAll(Arrays.asList(cli1));
		enderecoDao.saveAll(Arrays.asList(e1,e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoDao.saveAll(Arrays.asList(ped1,ped2));
		pagamentoDao.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.0);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.0);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.0);
		
		ped1.getItens().addAll(Arrays.asList(ip1));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		itemPedidoDao.saveAll(Arrays.asList(ip1,ip2));
		
		
		
	}
}

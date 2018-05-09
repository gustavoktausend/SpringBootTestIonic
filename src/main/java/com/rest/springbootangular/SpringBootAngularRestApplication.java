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
		Produto p4 = new Produto(null, "Mesa de Escritório", 300.0);
		Produto p5 = new Produto(null, "Toalha", 50.0);
		Produto p6 = new Produto(null, "Colcha", 300.0);
		Produto p7 = new Produto(null, "TV True Color", 1200.0);
		Produto p8 = new Produto(null, "Roçadeira", 800.0);
		Produto p9 = new Produto(null, "Abajour", 100.0);
		Produto p10 = new Produto(null, "Pendente", 300.0);
		Produto p11 = new Produto(null, "Shampoo", 90.0);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2 , p3));
		cat2.getProdutos().addAll(Arrays.asList(p2,p4));
		cat3.getProdutos().addAll(Arrays.asList(p5,p6));
		cat4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9,p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2,cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
		categoriaDao.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		produtoDao.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11));
		
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

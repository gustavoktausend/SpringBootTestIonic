package com.rest.springbootangular.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.springbootangular.dao.ItemPedidoDAO;
import com.rest.springbootangular.dao.PagamentoDAO;
import com.rest.springbootangular.dao.PedidoDAO;
import com.rest.springbootangular.dao.ProdutoDAO;
import com.rest.springbootangular.domain.ItemPedido;
import com.rest.springbootangular.domain.PagamentoComBoleto;
import com.rest.springbootangular.domain.Pedido;
import com.rest.springbootangular.domain.Produto;
import com.rest.springbootangular.domain.enums.EstadoPagamento;
import com.rest.springbootangular.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoDAO repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoDAO pagamentoRepo;
	
	@Autowired
	private ProdutoDAO produtoRepo;
	
	@Autowired
	private ItemPedidoDAO itemPedidoRepo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
			
		}
		obj = repo.save(obj);
		pagamentoRepo.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			Optional<Produto> produtoPorPedido = produtoRepo.findById(ip.getProduto().getId());
			ip.setPreco(produtoPorPedido.get().getPreco());
			ip.setPedido(obj);
				
		}
		itemPedidoRepo.saveAll( obj.getItens());
		return obj;
	}


}

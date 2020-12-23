package com.deniswillian.cursomcc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deniswillian.cursomcc.domain.ItemPedido;
import com.deniswillian.cursomcc.domain.PagamentoComBoleto;
import com.deniswillian.cursomcc.domain.Pedido;
import com.deniswillian.cursomcc.domain.enums.EstadoPagamento;
import com.deniswillian.cursomcc.repositories.ItemPedidoRepository;
import com.deniswillian.cursomcc.repositories.PagamentoRepository;
import com.deniswillian.cursomcc.repositories.PedidoRepository;
import com.deniswillian.cursomcc.services.exceptions.ObjectNotFounfException;

//import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounfException(
				"Objeto não encontrado! Id: "+ id + ", Tipo: "+ Pedido.class.getName()));
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}
	
}

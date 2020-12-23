package com.deniswillian.cursomcc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deniswillian.cursomcc.domain.Categoria;
import com.deniswillian.cursomcc.domain.Cidade;
import com.deniswillian.cursomcc.domain.Cliente;
import com.deniswillian.cursomcc.domain.Endereco;
import com.deniswillian.cursomcc.domain.Estado;
import com.deniswillian.cursomcc.domain.ItemPedido;
import com.deniswillian.cursomcc.domain.Pagamento;
import com.deniswillian.cursomcc.domain.PagamentoComBoleto;
import com.deniswillian.cursomcc.domain.PagamentoComCartao;
import com.deniswillian.cursomcc.domain.Pedido;
import com.deniswillian.cursomcc.domain.Produto;
import com.deniswillian.cursomcc.domain.enums.EstadoPagamento;
import com.deniswillian.cursomcc.domain.enums.TipoCliente;
import com.deniswillian.cursomcc.repositories.CategoriaRepository;
import com.deniswillian.cursomcc.repositories.CidadeRepository;
import com.deniswillian.cursomcc.repositories.ClienteRepository;
import com.deniswillian.cursomcc.repositories.EnderecoRepository;
import com.deniswillian.cursomcc.repositories.EstadoRepository;
import com.deniswillian.cursomcc.repositories.ItemPedidoRepository;
import com.deniswillian.cursomcc.repositories.PagamentoRepository;
import com.deniswillian.cursomcc.repositories.PedidoRepository;
import com.deniswillian.cursomcc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomccApplication implements CommandLineRunner{
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomccApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}

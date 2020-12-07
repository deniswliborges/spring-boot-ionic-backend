package com.deniswillian.cursomcc;

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
import com.deniswillian.cursomcc.domain.Produto;
import com.deniswillian.cursomcc.domain.enums.TipoCliente;
import com.deniswillian.cursomcc.repositories.CategoriaRepository;
import com.deniswillian.cursomcc.repositories.CidadeRepository;
import com.deniswillian.cursomcc.repositories.ClienteRepository;
import com.deniswillian.cursomcc.repositories.EnderecoRepository;
import com.deniswillian.cursomcc.repositories.EstadoRepository;
import com.deniswillian.cursomcc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomccApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;	
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomccApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia",est1); 
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27362333", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores","300","adto 303 "," Jardim", "38220834",cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos","105","Sala 800","Centro", "38777012",cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
	
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}

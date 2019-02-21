package com.produtos.apirest2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest2.models.Produto;
import com.produtos.apirest2.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	//salvar
	@PostMapping(value="/produto")
	public Produto salvar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	//pesquisa varios produtos
	@GetMapping(value="/produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	//retorna um único produto
	@GetMapping(value="/produto/{id}")
	public Produto unicoProduto(@PathVariable(value="id")long id) {
		return produtoRepository.findById(id);
	}
	
	//atualizar
	@PutMapping(value="/produto")
	public Produto atualizar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	//deletar
	@DeleteMapping(value="/produto")
	public void deletar(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
}

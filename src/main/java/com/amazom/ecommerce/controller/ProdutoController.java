package com.amazom.ecommerce.controller;


import java.util.List;

import com.amazom.ecommerce.dto.ProdutoDto;
import com.amazom.ecommerce.model.Produto;
import com.amazom.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
@Autowired
private ProdutoService service;
 
  @GetMapping
  public List<ProdutoDto> obterProdutos(){
     return service.obterTodosOsProdutos();
  }

  @GetMapping("/{id}")
  public ProdutoDto obterProdutoPorId(@PathVariable String id){

    return service.obterPorId(id);
  }

  @PostMapping
  public Produto cadastraProduto(@RequestBody Produto produto){

      produto= repository.save(produto);
      return produto;
  }
    
  @PutMapping("/{id}")
  public Produto alterarProduto(@PathVariable String id,@RequestBody Produto produto){
    produto.setId(id);
    produto = repository.save(produto);
    return produto;
  }

  @DeleteMapping("/{id}")
  public void excluirProduto(@PathVariable String id){
    repository.deleteById(id);
  }
}

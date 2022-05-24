package com.amazom.ecommerce.controller;


import java.util.List;
import java.util.Optional;

import com.amazom.ecommerce.model.Produto;
import com.amazom.ecommerce.model.repository.ProdutoRepository;

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
  private ProdutoRepository repository;

  @GetMapping
  public List<Produto> obterProdutos(){
      return repository.findAll();
  }

  @GetMapping("/{id}")
  public Produto obterProdutoPorId(@PathVariable String id){

    Optional<Produto> produto= repository.findById(id);

    if(produto.isPresent()){
        return produto.get();
    }
      return null;
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

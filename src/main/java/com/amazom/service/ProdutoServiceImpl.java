package com.amazom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.amazom.ecommerce.dto.ProdutoDto;
import com.amazom.ecommerce.model.Produto;
import com.amazom.ecommerce.model.repository.ProdutoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoServiceImpl implements ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    private ModelMapper mapper =new ModelMapper();

    @Override
    public List<ProdutoDto> obterTodosOsProdutos() {
    
        List<Produto> produtos =repository.findAll();
        
        return produtos.stream()
                .map(p->mapper.map(p, ProdutoDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public ProdutoDto obterPorId(String id) {
        Optional<Produto> produto= repository.findById(id);

    if(produto.isPresent()){
        return mapper.map(produto.get(), ProdutoDto.class) ;
    }
      return null;
  }
   

    @Override
    public ProdutoDto cadastrarProduto(ProdutoDto produto) {
        Produto produtoSalvar= mapper.map(produto,Produto.class);
        repository.save(produtoSalvar);
        return mapper.map(produtoSalvar,ProdutoDto.class);
    }

    @Override
    public void excluirProduto(Integer codigo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ProdutoDto alterarProduto(String id, ProdutoDto produto) {
        // TODO Auto-generated method stub
        return null;
    }

    
}

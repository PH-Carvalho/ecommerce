package com.amazom.ecommerce.model.repository;

import com.amazom.ecommerce.model.Produto;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto,String> {
    
}

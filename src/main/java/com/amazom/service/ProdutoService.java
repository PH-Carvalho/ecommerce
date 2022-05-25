package com.amazom.service;

import java.util.List;

import com.amazom.ecommerce.dto.ProdutoDto;

public interface ProdutoService {

List<ProdutoDto>obterTodosOsProdutos();
ProdutoDto obterPorId(String id);
ProdutoDto cadastrarProduto(ProdutoDto produto);
void excluirProduto(Integer codigo);
ProdutoDto alterarProduto(String id,ProdutoDto produto);



}

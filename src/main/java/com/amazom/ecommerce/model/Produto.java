package com.amazom.ecommerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("produto")
public class Produto {
    @Id
    private String id;
    private Integer codigo;
    private String descricao;
    private double valor;
    private double valorDeCusto;
    private String fornecedor;
    

    
    
    public double getValorDeCusto() {
        return valorDeCusto;
    }
    public void setValorDeCusto(double valorDeCusto) {
        this.valorDeCusto = valorDeCusto;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return String.format("%s R$ %.2f", descricao, valor);
    }





    
}

package com.naka.produto.api.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private boolean ativo;
}

package com.naka.produto.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Produto")
@Data
public class ProdutoResponse {

    @Schema(description="id do produto.")
    private Long id;

    @Schema(description="Nome do produto.")
    private String nome;

    @Schema(description="Descrição do produto.")
    private String descricao;

    @Schema(description="Preço do produto.")
    private BigDecimal preco;

    @Schema(description="Status do produto.")
    private boolean ativo;
}

package com.naka.produto.api.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Schema(description = "Informações para cadastro do produto")
@Data
public class ProdutoRequest {

    @Schema(description = "Nome do produto", required = true, example = "IPhone")
    @NotBlank
    private String nome;

    @Schema(description = "Descrição do produto", required = true, example = "Smartphone")
    @NotBlank
    private String descricao;

    @Schema(description = "Preço do produto", required = true, example = "999.99")
    @NotNull
    private BigDecimal preco;

    @Schema(description = "Status do produto", example = "true")
    private boolean ativo;
}

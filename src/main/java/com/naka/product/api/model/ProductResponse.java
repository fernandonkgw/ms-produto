package com.naka.product.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Produto")
@Data
public class ProductResponse {

    @Schema(description="id do produto.")
    private Long id;

    @Schema(description="Nome do produto.")
    private String name;

    @Schema(description="Descrição do produto.")
    private String description;

    @Schema(description="Preço do produto.")
    private BigDecimal price;

    @Schema(description="Status do produto.")
    private boolean enabled;
}

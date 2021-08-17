package com.naka.product.api.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Schema(description = "Informações para cadastro do produto")
@Data
public class ProductRequest {

    @Schema(description = "Nome do produto", required = true, example = "IPhone")
    @NotBlank
    private String name;

    @Schema(description = "Descrição do produto", required = true, example = "Smartphone")
    @NotBlank
    private String description;

    @Schema(description = "Preço do produto", required = true, example = "999.99")
    @NotNull
    private BigDecimal price;

    @Schema(description = "Status do produto", example = "true")
    private boolean enabled;
}

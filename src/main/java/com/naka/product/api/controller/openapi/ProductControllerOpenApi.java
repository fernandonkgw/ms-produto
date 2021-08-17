package com.naka.product.api.controller.openapi;

import com.naka.product.api.model.ProductResponse;
import com.naka.product.api.model.request.ProductRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Products", description="Catálogo de produtos.")
public interface ProductControllerOpenApi {

    @Operation(summary = "Cria um novo produto.",
            responses = @ApiResponse(responseCode="201", description="Quando criado um novo cliente."))
    ProductResponse add(ProductRequest productRequest);

    @Operation(summary = "Consulta um produto",
            parameters = {@Parameter(name = "id", description = "id do produto", example = "123") },
            responses = @ApiResponse(description = "Consulta realizada com sucesso."))
    ProductResponse findById(Long id);

    @Operation(summary = "Exclui um produto.",
            parameters = {@Parameter(name = "id", description = "id do cliente") },
            responses = @ApiResponse(responseCode="204", description="Quando excluído com sucesso."))
    void remove(Long id);

    @Operation(summary = "Atualiza informações de um produto.",
            responses = @ApiResponse(responseCode="200", description="Quando atualizado com sucesso."))
    ProductResponse update(Long id, ProductRequest productRequest);
}

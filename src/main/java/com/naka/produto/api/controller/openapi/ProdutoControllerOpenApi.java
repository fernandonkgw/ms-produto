package com.naka.produto.api.controller.openapi;

import com.naka.produto.api.model.ProdutoResponse;
import com.naka.produto.api.model.request.ProdutoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Produtos", description="Catálogo de produtos.")
public interface ProdutoControllerOpenApi {

    @Operation(summary = "Cria um novo produto.",
            responses = @ApiResponse(responseCode="201", description="Quando criado um novo cliente."))
    ProdutoResponse adiciona(ProdutoRequest produtoRequest);

    @Operation(summary = "Consulta um produto",
            parameters = {@Parameter(name = "id", description = "id do produto", example = "123") },
            responses = @ApiResponse(description = "Consulta realizada com sucesso."))
    ProdutoResponse busca(Long id);

    @Operation(summary = "Exclui um produto.",
            parameters = {@Parameter(name = "id", description = "id do cliente") },
            responses = @ApiResponse(responseCode="204", description="Quando excluído com sucesso."))
    void remove(Long id);

    @Operation(summary = "Atualiza informações de um produto.",
            responses = @ApiResponse(responseCode="200", description="Quando atualizado com sucesso."))
    ProdutoResponse atualiza(Long id, ProdutoRequest produtoRequest);
}

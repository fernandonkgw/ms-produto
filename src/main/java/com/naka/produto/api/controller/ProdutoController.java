package com.naka.produto.api.controller;

import com.naka.produto.api.controller.openapi.ProdutoControllerOpenApi;
import com.naka.produto.api.model.ProdutoResponse;
import com.naka.produto.api.model.request.ProdutoRequest;
import com.naka.produto.domain.model.Produto;
import com.naka.produto.domain.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/v1/produtos",
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController implements ProdutoControllerOpenApi {

    @Autowired
    private ProdutoService produtoService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse adiciona(@Valid @RequestBody ProdutoRequest produtoRequest) {

        Produto produto = toDomainObject(produtoRequest);

        produto = produtoService.adiciona(produto);

        ProdutoResponse produtoResponse = toResponse(produto);

        return produtoResponse;
    }

    @Override
    @GetMapping("/{id}")
    public ProdutoResponse busca(@PathVariable Long id) {
        Produto produto = produtoService.buscaOuFalha(id);

        ProdutoResponse produtoResponse = toResponse(produto);
        return produtoResponse;
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        produtoService.remove(id);
    }

    @Override
    @PutMapping("/{id}")
    public ProdutoResponse atualiza(@PathVariable Long id, @Valid @RequestBody ProdutoRequest produtoRequest) {
        Produto produto = toDomainObject(produtoRequest);
        produto.setId(id);

        produto = produtoService.atualiza(produto);

        ProdutoResponse produtoResponse = toResponse(produto);
        return produtoResponse;
    }

    private Produto toDomainObject(ProdutoRequest request) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(request, produto);
        return produto;
    }

    private ProdutoResponse toResponse(Produto produto) {
        ProdutoResponse response = new ProdutoResponse();
        BeanUtils.copyProperties(produto, response);
        return response;
    }
}

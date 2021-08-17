package com.naka.product.api.controller;

import com.naka.product.api.controller.openapi.ProductControllerOpenApi;
import com.naka.product.api.model.ProductResponse;
import com.naka.product.api.model.request.ProductRequest;
import com.naka.product.domain.model.Product;
import com.naka.product.domain.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/v1/products",
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController implements ProductControllerOpenApi {

    @Autowired
    private ProductService productService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse add(@Valid @RequestBody ProductRequest productRequest) {

        Product product = toDomainObject(productRequest);

        product = productService.add(product);

        ProductResponse productResponse = toResponse(product);

        return productResponse;
    }

    @Override
    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        Product product = productService.findOrFail(id);

        ProductResponse productResponse = toResponse(product);
        return productResponse;
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        productService.remove(id);
    }

    @Override
    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody ProductRequest productRequest) {
        Product product = toDomainObject(productRequest);
        product.setId(id);

        product = productService.update(product);

        ProductResponse productResponse = toResponse(product);
        return productResponse;
    }

    private Product toDomainObject(ProductRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        return product;
    }

    private ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        BeanUtils.copyProperties(product, response);
        return response;
    }
}

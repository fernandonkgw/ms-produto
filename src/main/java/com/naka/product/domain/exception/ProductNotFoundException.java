package com.naka.product.domain.exception;

public class ProductNotFoundException extends EntityNotFoundException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Long productId) {
        this(String.format("Não existe um cadastro de produto com código %d", productId));
    }
}

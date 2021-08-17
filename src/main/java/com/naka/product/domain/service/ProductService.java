package com.naka.product.domain.service;

import com.naka.product.domain.exception.ProductNotFoundException;
import com.naka.product.domain.model.Product;
import com.naka.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product add(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product findOrFail(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Transactional
    public void remove(Long id) {
        Product product = findOrFail(id);
        productRepository.delete(product);
    }

    @Transactional
    public Product update(Product product) {
        findOrFail(product.getId());
        product = productRepository.save(product);
        return product;
    }
}

package com.naka.produto.domain.service;

import com.naka.produto.domain.exception.ProdutoNaoEncontradoException;
import com.naka.produto.domain.model.Produto;
import com.naka.produto.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto adiciona(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public Produto buscaOuFalha(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    @Transactional
    public void remove(Long id) {
        Produto produto = buscaOuFalha(id);
        produtoRepository.delete(produto);
    }

    @Transactional
    public Produto atualiza(Produto produto) {
        buscaOuFalha(produto.getId());
        produto = produtoRepository.save(produto);
        return produto;
    }
}

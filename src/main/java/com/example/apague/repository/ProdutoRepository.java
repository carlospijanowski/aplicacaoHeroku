package com.example.apague.repository;


import com.example.apague.model.ProdutoDTO.java.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {

    private int ultimoProdutoRegistrado;
    List<Produto> produtoList = new ArrayList<>();

    public List<Produto> listarTodosOsProdutos() {
        return produtoList;
    }

    public Optional<Produto> procurarPorUnicoProduto(int codigoProduto) {
        return produtoList
                .stream()
                .filter(produto -> produto.getId() == codigoProduto)
                .findFirst();
    }

    public Produto cadastrarUmProduto(Produto produto) {
        produto.setId(ultimoProdutoRegistrado++);
        produtoList.add(produto);
        return produto;
    }

    public void deletarUmPorduto(int codigoProduto) {
        produtoList.removeIf(produto -> produto.getId() == codigoProduto);
    }

}

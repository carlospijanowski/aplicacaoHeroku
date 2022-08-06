package com.example.apague.model.ProdutoDTO.java;

public class Produto {

    private int id;
    private String nomeProduto;
    private double precoProduto;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }
}

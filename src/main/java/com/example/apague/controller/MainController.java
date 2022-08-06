package com.example.apague.controller;

import com.example.apague.model.ProdutoDTO.java.Produto;
import com.example.apague.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Value("${nome}")
    String teste;

    @RequestMapping("/")
    public String pagina1(){
        return "pagina sem layout no main "+teste;
    }

    @RequestMapping("/teste/{parametro}")
    public String pagina2(@PathVariable(value = "parametro")String parametro){
        return "pagina teste" + parametro;
    }

    @PostMapping("/cadastrar")
    public Produto cadastrarProduto(@RequestBody Produto produto){
        return produtoRepository.cadastrarUmProduto(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> listaTodosOsProdutosCadastrados(){
        return produtoRepository.listarTodosOsProdutos();
    }


}

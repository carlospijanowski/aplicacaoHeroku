package com.example.apague.dao;
import com.example.apague.model.Categoria;
import com.example.apague.model.Despesa;

import java.util.List;
import java.util.Optional;

public interface IDespesaDAO {
    Despesa save(Despesa despesa);

    Despesa update(Despesa despesa);

    void delete(Long id);

    List<Despesa> findAll();

    Optional<Despesa> fndById(Long id);

    List<Despesa> findByCategoria(Categoria categoria);
}

package com.example.apague.dao;

import com.example.apague.infra.ConnectionFactory;
import com.example.apague.model.Categoria;
import com.example.apague.model.Despesa;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class DespesaDAOImpl implements IDespesaDAO {
    @Override
    public Despesa save(Despesa despesa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO Despesas (descricao,valor,data,categoria) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, despesa.getDescricao());
            preparedStatement.setDouble(2, despesa.getValor());
            preparedStatement.setDate(3, Date.valueOf(despesa.getData()));
            preparedStatement.setString(4, despesa.getCategoria().toString());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();//ele sempre fica uma posicao antes, por isso devo passar para a proxima
            long idCriadoPeloBanco = generatedKeys.getLong("id");
            despesa.setId(idCriadoPeloBanco);

        } catch (SQLException ex) {

        }
        return despesa;
    }

    @Override
    public Despesa update(Despesa despesa) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Despesa> findAll() {
        String sql = "select * from Despesas";

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            //TODO parei aqui
        } catch (SQLException ex) {

        }

        return null;
    }

    @Override
    public Optional<Despesa> fndById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Despesa> findByCategoria(Categoria categoria) {
        return null;
    }
}

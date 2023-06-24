package com.example.apague.dao;

import com.example.apague.infra.ConnectionFactory;
import com.example.apague.model.Categoria;
import com.example.apague.model.Despesa;
import com.example.apague.model.ObjetoCorreios;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class CepDAOImpl implements ICepDAO {

    @Override
    public ObjetoCorreios save(ObjetoCorreios cep) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO cep (cep,logradouro,complemento,bairro) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cep.getCep());
            preparedStatement.setString(2, cep.getLogradouro());
            preparedStatement.setString(3, cep.getComplemento());
            preparedStatement.setString(4, cep.getBairro());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();//ele sempre fica uma posicao antes, por isso devo passar para a proxima
            long idCriadoPeloBanco = generatedKeys.getLong("id");
            cep.setId(idCriadoPeloBanco);

        } catch (SQLException ex) {

        }
        return cep;
    }
}

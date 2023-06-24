package com.example.apague.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory(){

    }

    public static Connection getConnection(){
        try {
//            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5438/DespesasDB", "postgres", "postgres");
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("ERRO AO CONECTAR AO BANCO DE DADOS");
        }
    }
}

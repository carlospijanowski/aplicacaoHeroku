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
                    "jdbc:postgresql://ec2-44-213-151-75.compute-1.amazonaws.com:5432/da27kq8remub22",
                    "kpeeblcrjkceqg",
                    "300084f121abedfb152dd8ecfd4b7f6375d85296fabeb59fd382e0c57fd74ee6");


//            return DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5438/DespesasDB",
//                    "postgres",
//                    "postgres");
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("ERRO AO CONECTAR AO BANCO DE DADOS");
        }
    }
}

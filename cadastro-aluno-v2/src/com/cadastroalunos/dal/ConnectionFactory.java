package com.cadastroalunos.dal;

import com.cadastroalunos.modules.Aluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectionFactory {
    private String url = "jdbc:derby://10.10.11.122:1527/home/databases/cadastro-alunos";
    private String user = "root";
    private String password = "123";

    public Connection getConnection() {
        try {
            getClass().forName("org.apache.derby.jdbc.ClientDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {

        }
        return null;
    }

}

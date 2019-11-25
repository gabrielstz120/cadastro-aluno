package com.cadastroalunos.tests;

import com.cadastroalunos.dal.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroAlunosTests {

    public static void main(String[] args) {
        new CadastroAlunosTests().test();
    }

    public void test() {
        Connection connection = new ConnectionFactory().getConnection();
        try {
            int contador = 0;
            PreparedStatement preparedStatement = connection.prepareStatement("select * from root.cad_alunos", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = preparedStatement.executeQuery();
            lp:
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                //contador = contador + 1;
                //contador += 1;
                //contador++;
                if (contador++ < 5) {
                    resultSet.beforeFirst();
                    continue lp;
                }
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

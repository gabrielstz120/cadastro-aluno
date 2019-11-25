package com.cadastroalunos.dal;

import com.cadastroalunos.modules.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    /**
     * lê um aquivo de alunos.
     *
     * @return lista de alunos
     */
    public List<Aluno> findAll() {
        List<Aluno> list = new ArrayList();
        try {
            Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("SELECT * FROM ROOT.CAD_ALUNOS ORDER BY NOME ASC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(
                        new Aluno(
                                resultSet.getString(2),
                                resultSet.getInt(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                resultSet.getString(8),
                                resultSet.getDate(9),
                                resultSet.getString(10),
                                resultSet.getString(11)
                        ));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean save(Aluno aluno) {
        try {
            Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ROOT.CAD_ALUNOS (ID, NOME, IDADE, NASCIMENTO, ESCOLARIDADE, CURSANDO, NOME_PAI, NOME_MAE, ENDERECO, BAIRRO, CIDADE) values  (next value for seq_cad_alunos, ? , ?, ?, ? , ?, ?, ? , ?, ?, ?) ");
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setInt(2, aluno.getIdade());
            preparedStatement.setTimestamp(3, new Timestamp(aluno.getNascimento().toInstant().toEpochMilli()));
            preparedStatement.setString(4, aluno.getEscolaridade());
            preparedStatement.setString(5, aluno.getCursando());
            preparedStatement.setString(6, aluno.getNaomePai());
            preparedStatement.setString(7, aluno.getNomeMae());
            preparedStatement.setString(8, aluno.getEndereco());
            preparedStatement.setString(9, aluno.getBairro());
            preparedStatement.setString(10, aluno.getCidade());
            preparedStatement.execute();
            connection.commit();
            preparedStatement.close();
            connection.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(String nomeAluno) {
        Connection connection = new ConnectionFactory().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ROOT.CAD_ALUNOS WHERE lower(NOME) LIKE ?");
            preparedStatement.setString(1, nomeAluno.toLowerCase().concat("%"));
            preparedStatement.execute();
            connection.commit();
            preparedStatement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

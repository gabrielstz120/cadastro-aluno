package io.github.gabrielstz120.utils;

import io.github.gabrielstz120.entities.Aluno;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Util {
    /**
     * Pede informações para o usuario para criar um aluno novo.
     *
     * @param scanner inputstream de dados
     * @return aluno novo
     */
    public Aluno getAlunoFromUser(Scanner scanner) {
        Aluno aluno = new Aluno();
        System.out.print("Digite o Nome do Aluno -> ");
        aluno.setNome(scanner.nextLine());
        System.out.print("Digite sua Idade -> ");
        aluno.setIdade(Integer.parseInt(scanner.nextLine()));
        System.out.print("Digite o Nome do Pai -> ");
        aluno.setNaomePai(scanner.nextLine());
        System.out.print("Digite o Nome da Mãe -> ");
        aluno.setNomeMae(scanner.nextLine());
        System.out.print("Digite seu Grau de Escolaridade -> ");
        aluno.setEscolaridade(scanner.nextLine());
        System.out.print("Digite oque esta Cursando -> ");
        aluno.setCursando(scanner.nextLine());
        System.out.print("Digite seu Endereço -> ");
        aluno.setEndereco(scanner.nextLine());
        System.out.print("Digite seu Bairro -> ");
        aluno.setBairro(scanner.nextLine());
        System.out.print("Digite sua Cidade -> ");
        aluno.setCidade(scanner.nextLine());
        System.out.print("Digite a Data de Nascimento -> ");
        try {
            aluno.setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return aluno;
    }

    /**
     * Pega um arquivo.
     *
     * @param fileName nome do arquivo
     * @return retorna o arquivo que pediu
     */
    private File getFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * Escreve em um arquivo.
     *
     * @param fileName nome do arquivo de destino
     * @param lista    lista de linhas que serão escritas
     */
    public void writeToFile(String fileName, List lista) {
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter((getFile(fileName))));
            lista.stream().forEach(o -> {
                try {
                    fileWriter.append(o.toString());
                    fileWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception ex) {

        }
    }

    /**
     * Lê um arquivo de linhas e exporta para um arquivo json.
     *
     * @param list
     */
    public void exportarJson(List<Aluno> list) {
        writeToFile("alunos.json", Arrays.asList(new Gson().toJson(list, new TypeToken<List<Aluno>>() {
        }.getType())));
    }
}

package io.github.gabrielstz120.views;

import io.github.gabrielstz120.entities.Aluno;
import io.github.gabrielstz120.repositories.AlunoRepository;
import io.github.gabrielstz120.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Sistema {
    @Autowired
    private AlunoRepository repository;
    private Scanner scanner = new Scanner(System.in);
    private Util util = new Util();

    private String getBemVindo() {
        return getSeparacao() + "\n\t\tBem Vindo\nSistema Cadastro de alunos\n" + getSeparacao();
    }

    private String getSeparacao() {
        return "--------------------------------";
    }

    private String getMenu() {
        return getSeparacao() + "\n\t\t\tMenu\n" + getSeparacao() +
                "\n1- Cadastrar o Aluno" +
                "\n2- Excluir " +
                "\n3- Imprimir" +
                "\n4- Exportar (json)" +
                "\n5- Encerar Sistema";
    }

    /**
     * Cadastra um aluno.
     *
     * @param aluno aluno que sera cadastrado
     */
    private void cadastarAluno(Aluno aluno) {
        repository.save(aluno);
        System.out.println("\nAluno cadastrado com Sucesso\n");
    }

    /**
     * Exclui os alunos salvos
     *
     * @param fileName nome do arquivo
     */
    private void excluirAluno(String fileName) {
        System.out.print("Digite o nome do Aluno que deseja Excluir -> ");
        repository.delete(repository.findByNome(scanner.nextLine()));
        System.out.println("Aluno Excluido com Sucesso");
    }

    /**
     * Mostra a lista de aluno
     */
    private void listarAlunos() {
        repository.findAll().forEach(System.out::println);
    }

    /**
     * exporta lista de alunos salvos para json
     */
    private void exportarJson() {
        util.exportarJson(repository.findAll());
        System.out.println("\nAlunos Exportados com Sucesso\n");
    }

    /**
     * Inicia o sistema.
     */
    public void initSystem() {
        System.out.println(getBemVindo());
        while (true) {
            System.out.println(getMenu());
            System.out.print("Digite a opção -> \r");
            try {
                int opcao = new Scanner(System.in).nextInt();
                if (opcao == 1) {
                    cadastarAluno(util.getAlunoFromUser(scanner));
                } else if (opcao == 2) {
                    excluirAluno("cadastro.txt");
                } else if (opcao == 3) {
                    listarAlunos();
                } else if (opcao == 4) {
                    exportarJson();
                } else if (opcao == 5) {
                    System.exit(0);
                } else {
                    System.out.println("opcao invalida");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("caractere invalido");
            }
        }
    }
}

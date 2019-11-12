import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().initSystem();
    }

    class Aluno {
        private String nome;
        private String idade;
        private String escolaridade;
        private String cursando;
        private String naomePai;
        private String nomeMae;
        private String endereco;
        private String nascimento;
        private String bairro;
        private String cidade;

        public Aluno() {
        }

        public Aluno(String nome, String idade, String escolaridade, String cursando, String naomePai, String nomeMae, String endereco, String nascimento, String bairro, String cidade) {
            this.nome = nome;
            this.idade = idade;
            this.escolaridade = escolaridade;
            this.cursando = cursando;
            this.naomePai = naomePai;
            this.nomeMae = nomeMae;
            this.endereco = endereco;
            this.nascimento = nascimento;
            this.bairro = bairro;
            this.cidade = cidade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getIdade() {
            return idade;
        }

        public void setIdade(String idade) {
            this.idade = idade;
        }

        public String getEscolaridade() {
            return escolaridade;
        }

        public void setEscolaridade(String escolaridade) {
            this.escolaridade = escolaridade;
        }

        public String getCursando() {
            return cursando;
        }

        public void setCursando(String cursando) {
            this.cursando = cursando;
        }

        public String getNaomePai() {
            return naomePai;
        }

        public void setNaomePai(String naomePai) {
            this.naomePai = naomePai;
        }

        public String getNomeMae() {
            return nomeMae;
        }

        public void setNomeMae(String nomeMae) {
            this.nomeMae = nomeMae;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getNascimento() {
            return nascimento;
        }

        public void setNascimento(String nascimento) {
            this.nascimento = nascimento;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Aluno aluno = (Aluno) o;
            return Objects.equals(nome, aluno.nome) &&
                    Objects.equals(idade, aluno.idade) &&
                    Objects.equals(escolaridade, aluno.escolaridade) &&
                    Objects.equals(cursando, aluno.cursando) &&
                    Objects.equals(naomePai, aluno.naomePai) &&
                    Objects.equals(nomeMae, aluno.nomeMae) &&
                    Objects.equals(endereco, aluno.endereco) &&
                    Objects.equals(nascimento, aluno.nascimento) &&
                    Objects.equals(bairro, aluno.bairro) &&
                    Objects.equals(cidade, aluno.cidade);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, idade, escolaridade, cursando, naomePai, nomeMae, endereco, nascimento, bairro, cidade);
        }

        @Override
        public String toString() {
            return "Aluno{" +
                    "nome='" + nome + '\'' +
                    ", idade='" + idade + '\'' +
                    ", escolaridade='" + escolaridade + '\'' +
                    ", cursando='" + cursando + '\'' +
                    ", naomePai='" + naomePai + '\'' +
                    ", nomeMae='" + nomeMae + '\'' +
                    ", endereco='" + endereco + '\'' +
                    ", nascimento='" + nascimento + '\'' +
                    ", bairro='" + bairro + '\'' +
                    ", cidade='" + cidade + '\'' +
                    '}';
        }
    }

    String getBemVindo() {
        return getSeparacao() + "\n\t\tBem Vindo\nSistema Cadastro de alunos\n" + getSeparacao();
    }

    String getSeparacao() {
        return "--------------------------------";
    }

    String getMenu() {
        return getSeparacao() + "\n\t\t\tMenu\n" + getSeparacao() +
                "\n1- Cadastrar o Aluno" +
                "\n2- Excluir " +
                "\n3- Imprimir" +
                "\n4- Exportar (json)" +
                "\n5- Encerar Sistema";
    }

    String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    void initSystem() {
        System.out.println(getBemVindo());
        while (true) {
            System.out.println(getMenu());
            System.out.print("Digite a opção -> ");
            int opcao = new Scanner(System.in).nextInt();
            if (opcao == 1) {
                System.out.println("Cadastrando Aluno");
            } else if (opcao == 2) {
                System.out.println("Excluindo");
            } else if (opcao == 3) {
                System.out.println("Imprimindo");
            } else if (opcao == 4) {
                System.out.println("Exportando");
            } else if (opcao == 5) {
                System.out.println("Encerrando o Sistema");
            }else {
                System.out.println("opcao invalida");
            }
        }
    }
}

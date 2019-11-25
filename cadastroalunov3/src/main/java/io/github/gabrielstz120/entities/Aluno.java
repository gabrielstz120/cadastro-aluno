package io.github.gabrielstz120.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAD_ALUNOS")
@SequenceGenerator(name = "seq_cad_alunos", allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "aluno.findAll", query = "SELECT al FROM Aluno al"),
        @NamedQuery(name = "aluno.findByNome", query = "SELECT al FROM Aluno al WHERE LOWER(al.nome) LIKE :nome")
})
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cad_alunos")
    private Long id;
    @Column(name = "NOME", length = 150)
    private String nome;
    @Column(name = "IDADE")
    private Integer idade;
    @Column(name = "ESCOLARIDADE", length = 100)
    private String escolaridade;
    @Column(name = "CURSANDO", length = 100)
    private String cursando;
    @Column(name = "NOMEPAI", length = 150)
    private String naomePai;
    @Column(name = "NOMEMAE", length = 150)
    private String nomeMae;
    @Column(name = "ENDERECO")
    private String endereco;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "NASCIMENTO", length = 29)
    private Date nascimento;
    @Column(name = "BAIRRO", length = 100)
    private String bairro;
    @Column(name = "CIDADE", length = 100)
    private String cidade;

}

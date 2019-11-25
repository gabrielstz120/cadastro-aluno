package com.cadastroalunos.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    private String nome;
    private Integer idade;
    private String escolaridade;
    private String cursando;
    private String naomePai;
    private String nomeMae;
    private String endereco;
    private Date nascimento;
    private String bairro;
    private String cidade;

}

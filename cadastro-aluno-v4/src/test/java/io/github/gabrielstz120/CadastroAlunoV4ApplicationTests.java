package io.github.gabrielstz120;

import io.github.gabrielstz120.entities.Aluno;
import io.github.gabrielstz120.repositories.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CadastroAlunoV4ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private AlunoRepository repository;

    @Test
    public void alunoDaoTest() {
		Aluno aluno = new Aluno().builder()
				.nome("Gabriel")
				.cidade("Sertãozinho")
				.build();
        assertNotEquals(aluno,repository.save(aluno));
        assertNotEquals(Collections.emptyList(), repository.findAll());
        repository.delete(repository.findByNome("gabriel"));
    }

}

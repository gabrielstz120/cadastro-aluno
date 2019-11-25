package io.github.gabrielstz120.tests;

import io.github.gabrielstz120.dal.AlunoDao;
import io.github.gabrielstz120.entities.Aluno;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTests {

    @Test
    @Order(1)
    public void daoTest() {
        AlunoDao alunoDao = new AlunoDao();
        assertTrue(alunoDao.save(new Aluno().builder()
                .nome("Gabriel")
                .cidade("Sertãozinho")
                .build()));
        assertNotEquals(Collections.emptyList(), alunoDao.findAll());
        assertTrue(alunoDao.delete("gabriel"));
    }

}

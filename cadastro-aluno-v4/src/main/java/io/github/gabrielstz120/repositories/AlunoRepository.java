package io.github.gabrielstz120.repositories;

import io.github.gabrielstz120.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Query(name = "aluno.findByNome")
    public Aluno findByNome(String nome);
}

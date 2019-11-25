package io.github.gabrielstz120.dal;

import io.github.gabrielstz120.entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class AlunoDao {

    /**
     * lê um aquivo de alunos.
     *
     * @return lista de alunos
     */
    public List<Aluno> findAll() {
        try {
            EntityManager entityManager = new EntityManagerFactoryHelper().getEntityManager();
            Query query = entityManager.createNamedQuery("aluno.findAll", Aluno.class);
            entityManager.getTransaction().begin();
            List<Aluno> list = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public boolean save(Aluno aluno) {
        try {
            EntityManager entityManager = new EntityManagerFactoryHelper().getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(String nomeAluno) {
        try {
            EntityManager entityManager = new EntityManagerFactoryHelper().getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("aluno.findByNome", Aluno.class);
            query.setParameter("nome", nomeAluno.concat("%"));
            entityManager.remove(query.getSingleResult());
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

package io.github.gabrielstz120.dal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class EntityManagerFactoryHelper {

    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("ALUNO_PU", getProperties()).createEntityManager();
    }

    private Map<String, Object> getProperties() {
        Map<String, Object> map = new HashMap();
        return map;
    }
}

package springboot.repository;

import javax.persistence.EntityManager;

public class RepositoryGeneric {

    private final EntityManager em;

    public RepositoryGeneric(EntityManager em) {
        this.em = em;
    }
}

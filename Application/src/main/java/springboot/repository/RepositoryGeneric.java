package springboot.repository;

import javax.persistence.EntityManager;

public class RepositoryGeneric{

    protected final EntityManager em;

    public RepositoryGeneric(EntityManager em) {
        this.em = em;
    }

}

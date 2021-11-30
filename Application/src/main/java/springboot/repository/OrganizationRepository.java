package springboot.repository;

import springboot.domain.Organization;
import springboot.domain.Schedule;
import springboot.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OrganizationRepository extends RepositoryGeneric implements OrganizationRepositoryInterface{

    public OrganizationRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<Organization> getOrganizationById(int id) {
        Optional<Organization> opt = Optional.of(em.createQuery("select x from Organization x where x.id = :id", Organization.class)
                .setParameter("id", id).getSingleResult());

        return opt;
    }

    @Override
    public List<Organization> getOrganizationByName(String name) {
        List<Organization> org = em.createQuery("select x from Organization x where x.name = :name", Organization.class)
                .setParameter("name", name).getResultList();
        return org;
    }

    @Override
    public List<Organization> getOrganizationByOwnerId(int id) {
        List<Organization> org = em.createQuery("select x from Organization x where x.owner_id = :owner_id", Organization.class)
                .setParameter("owner_id", owner_id).getResultList();

        return org;
    }

    @Override
    public List<Organization> getAll() {
        List<Organization> organizations = em.createQuery("select o from Organization o", Organization.class)
                .getResultList();
        return organizations;
    }

    @Override
    public Optional<Organization> save(Organization organization) {
        return Optional.empty();
    }

    @Override
    public Optional<Organization> delete(int id) {
        return Optional.empty();
    }
}

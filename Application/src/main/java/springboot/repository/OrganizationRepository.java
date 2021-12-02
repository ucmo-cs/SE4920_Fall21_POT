package springboot.repository;

import springboot.domain.Organization;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OrganizationRepository extends RepositoryGeneric implements OrganizationRepositoryInterface{

    public OrganizationRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<Organization> getOrganizationById(int id) {
        Optional<Organization> opt =
                em.createQuery("select x from Organization x where x.id = :id", Organization.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst();
        return opt;
    }

    @Override
    public List<Organization> getOrganizationByName(String name) {
        List<Organization> list =
                em.createQuery("select x from Organization x where x.name = :name", Organization.class)
                .setParameter("name", name)
                .getResultList();
        return list;
    }

    @Override
    public List<Organization> getOrganizationByOwnerId(int owner_id) {
        List<Organization> list =
                em.createQuery("select x from Organization x where x.owner_id = :owner_id", Organization.class)
                .setParameter("owner_id", owner_id)
                .getResultList();
        return list;
    }

    @Override
    public List<Organization> getAll() {
        List<Organization> list =
                em.createQuery("select o from Organization o", Organization.class)
                .getResultList();
        return list;
    }

    @Override
    public Optional<Organization> save(Organization organization) {
        em.persist(organization);
        return Optional.of(organization);
    }

    @Override
    public Optional<Organization> delete(int id) {
        Optional<Organization> opt =
                em.createQuery("select x from Organization x where x.id = :id", Organization.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst();
        if(opt.isPresent()){
            em.remove(opt.get());
        }
        return opt;
    }

    @Override
    public Optional<Organization> update(Organization org) {
        Optional<Organization> opt =
                em.createQuery("select x from Organization x where x.id = :id", Organization.class)
                .setParameter("id", org.getId())
                .getResultStream()
                .findFirst();
        if(opt.isPresent()){
            em.persist(org);
        }
        return opt;
    }


}

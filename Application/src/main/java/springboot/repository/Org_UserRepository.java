package springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import springboot.domain.Org_User;
import springboot.domain.Organization;
import springboot.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class Org_UserRepository extends RepositoryGeneric implements Org_UserRepositoryInterface{

    @Autowired
    private OrganizationRepositoryInterface organizationRepository;
    @Autowired
    private UserRepositoryInterface userRepository;

    public Org_UserRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<Organization> getOrganizationByUserId(int id) {
        Optional<Org_User> a = em.createQuery("select x from Org_User x where x.user_id = :user_id", Org_User.class)
                .setParameter("user_id", id)
                .getResultStream()
                .findFirst();
        System.out.println(a);
        if(a!=null && a.isPresent()){
            return organizationRepository.getOrganizationById(a.get().getOrgId());
        }
//        List<Organization> b = null;
//        for(int x = 0; x<a.size(); x++){
//            Org_User c = a.get(x);
//            int d = c.getOrgId();
//            Optional<Organization> e = organizationRepository.getOrganizationById(d);
//            Organization f = e.isPresent() ? e.get() : null;
//            b.add(f);
//        }
        return null;
    }

    @Override
    public List<User> getUsersByOrganizationId(int id) {
        List<Org_User> a = em.createQuery("select x from Org_User x where x.org_id = :org_id", Org_User.class)
                .setParameter("org_id", id)
                .getResultList();
        List<User> b = null;
        for(int x = 0; x<a.size(); x++){
            Org_User c = a.get(x);
            int d = c.getUserId();
            Optional<User> e = userRepository.getUserById(d);
            User f = e.isPresent() ? e.get() : null;
            b.add(f);
        }
        return b;
    }

    @Override
    public Optional<Org_User> addUserToOrganization(Org_User orgUser) {
        em.persist(orgUser);
        return Optional.of(orgUser);
    }

    @Override
    public Optional<User> deleteUserFromOrganization(Org_User orgUser) {
        Optional<Org_User> opt = Optional.of(em.createQuery("select x from Org_User x where x.org_id = :org_id and x.user_id = :user_id", Org_User.class)
                .setParameter("org_id", orgUser.getOrgId())
                .setParameter("user_id", orgUser.getUserId())
                .getSingleResult());
        if(opt.isPresent()){
            em.remove(opt.get());
            return userRepository.getUserById(opt.get().getUserId());
        }
        return null;
    }
}

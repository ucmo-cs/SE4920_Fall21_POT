package springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.Credentials;

public interface LoginRepository extends JpaRepository<Credentials,String> {


}

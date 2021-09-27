package springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.domain.Car;

import java.util.List;

@Repository
public interface CarDao extends CrudRepository<Car, Integer> {

    List<Car> findByMake(String make);
}

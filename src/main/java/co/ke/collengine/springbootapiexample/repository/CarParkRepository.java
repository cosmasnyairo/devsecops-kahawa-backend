package co.ke.collengine.springbootapiexample.repository;

import co.ke.collengine.springbootapiexample.entity.CarParkDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarParkRepository extends CrudRepository<CarParkDetails, Long> {
    List<CarParkDetails> findCarParkDetailsByParkingName(String name);

}

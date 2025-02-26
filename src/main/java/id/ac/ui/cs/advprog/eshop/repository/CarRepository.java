package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import java.util.List;
import java.util.Optional;

public interface CarRepository {
    Car create(Car car);
    List<Car> findAll();
    Optional<Car> findById(String id);
    Car update(String id, Car updatedCar);
    void delete(String id);
}

package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryCarRepository implements CarRepository {
    private final List<Car> carData = new ArrayList<>();

    @Override
    public Car create(Car car) {
        car.setCarId(CarIdGenerator.generateId());
        carData.add(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(carData);
    }

    @Override
    public Optional<Car> findById(String id) {
        return carData.stream().filter(car -> car.getCarId().equals(id)).findFirst();
    }

    @Override
    public Car update(String id, Car updatedCar) {
        Optional<Car> carOptional = findById(id);
        carOptional.ifPresent(car -> {
            car.setCarName(updatedCar.getCarName());
            car.setCarColor(updatedCar.getCarColor());
            car.setCarQuantity(updatedCar.getCarQuantity());
        });
        return carOptional.orElse(null);
    }

    @Override
    public void delete(String id) {
        carData.removeIf(car -> car.getCarId().equals(id));
    }
}

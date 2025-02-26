package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import id.ac.ui.cs.advprog.eshop.util.CarValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car create(Car car) {
        if (!CarValidator.isValid(car)) {
            throw new IllegalArgumentException("Invalid car data");
        }
        return carRepository.create(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(String carId) {
        return carRepository.findById(carId);
    }

    @Override
    public Car update(String carId, Car car) {
        return carRepository.update(carId, car);
    }

    @Override
    public void deleteCarById(String carId) {
        carRepository.delete(carId);
    }
}

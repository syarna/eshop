package id.ac.ui.cs.advprog.eshop.util;

import id.ac.ui.cs.advprog.eshop.model.Car;

public class CarValidator {
    public static boolean isValid(Car car) {
        return car != null && car.getCarName() != null && !car.getCarName().isEmpty();
    }
}

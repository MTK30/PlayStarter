package services;

import models.Car;
import repositories.CarRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class CarDetailsService {
    private final CarRepository carRepository;

    @Inject
    public CarDetailsService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<Car> getAllCarDetails() {
        return carRepository.fetchAllTheCarDetails();
    }
}

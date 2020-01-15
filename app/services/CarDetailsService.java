package services;

import models.Car;
import repositories.CarRepository;
import skeletons.exception.TrainCustomException;
import skeletons.response.CarResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CarDetailsService {
    private final CarRepository carRepository;

    @Inject
    public CarDetailsService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<CarResponse> getAllCarDetails() {
        List<Car> cars;
        try {
            cars = carRepository.fetchAllTheCarDetails();
        }catch(Exception ex) {
             throw new TrainCustomException(500,"SQL Error","Error while fetching Details from the car details table");
        }
        List<CarResponse> carResponseList = new ArrayList<>();
        cars.forEach(car -> {
            CarResponse carResponse = new CarResponse();
            carResponse.setName(car.getName());
            carResponse.setCabAccomodate(car.getCabAccomodate());
            carResponse.setCarType(car.getCarType());
            carResponseList.add(carResponse);
        });
        return carResponseList;
    }
}

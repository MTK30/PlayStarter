package repositories;

import models.Car;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class CarRepository extends EbeanRepository<Car,Integer> {
    public CarRepository() {
        super(Car.class);
    }

    public List<Car> fetchAllTheCarDetails() {
        return getCabSharingReadctx().find(Car.class)
                .findList();
    }

}

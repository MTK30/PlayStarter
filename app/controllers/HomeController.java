package controllers;

import models.Car;
import play.libs.Json;
import play.mvc.*;
import services.CarDetailsService;
import skeletons.SucessResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
@Singleton
public class HomeController extends Controller {

    private final CarDetailsService carDetailsService;

    @Inject
    public HomeController(CarDetailsService carDetailsService) {
        this.carDetailsService = carDetailsService;
    }

    public Result index() {
        List<Car> cars = carDetailsService.getAllCarDetails();
        //:TODO
        Car car = cars.get(0);
        return ok(Json.toJson(new SucessResponse(car)));
    }
    
    public Result explore() {
        return ok(views.html.explore.render());
    }
    
    public Result tutorial() {
        return ok(views.html.tutorial.render());
    }

}

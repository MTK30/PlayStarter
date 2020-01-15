package controllers;

import play.libs.Json;
import play.mvc.*;
import services.CarDetailsService;
import skeletons.exception.TrainCustomException;
import skeletons.response.CarResponse;
import skeletons.response.SuccessResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
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

    public Result getCarDemo() {
        List<CarResponse> carsResponse;
        try {
            throw new TrainCustomException(500,"Exception in service","Exception in Sevice of CarDetailService");
//            carsResponse = carDetailsService.getAllCarDetails();
        } catch(Exception ex) {
            throw new TrainCustomException(500,"Exception in service","Exception in Sevice of CarDetailService");
        }
//        return ok(Json.toJson(new SuccessResponse(carsResponse)));
    }
    
    public Result explore() {
        return ok(views.html.explore.render());
    }
    
    public Result tutorial() {
        return ok(views.html.tutorial.render());
    }

}

//package controllers;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import play.libs.Json;
//import play.mvc.*;
//import skeletons.exception.TrainCustomException;
//import skeletons.response.SuccessResponse;
//
//import javax.inject.Inject;
//import javax.inject.Singleton;
//
///**
// * This controller contains an action to handle HTTP requests
// * to the application's home page.
// */
//@Singleton
//public class HomeController extends Controller {
//
//    private final CarDetailsService carDetailsService;
//
//    @Inject
//    public HomeController(CarDetailsService carDetailsService) {
//        this.carDetailsService = carDetailsService;
//    }
//
//    public Result getCarDemo() {
//        JsonNode jsonNode = null;
//        try {
////            jsonNode = Json.toJson(carDetailsService.getAllCarDetails());
//        } catch(Exception ex) {
//           jsonNode = Json.toJson(new TrainCustomException(500,"Exception in service","Exception in Sevice of CarDetailService"));
//        }
//        return ok(Json.toJson(new SuccessResponse(jsonNode)));
//    }
//
//    public Result explore() {
//        return ok(views.html.explore.render());
//    }
//
//    public Result tutorial() {
//        return ok(views.html.tutorial.render());
//    }
//
//}

package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.AdminService;
import skeletons.exception.TrainCustomException;
import skeletons.request.LoginRegisterDetailsRequest;
import skeletons.request.LoginRequest;
import skeletons.response.SuccessResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import static play.mvc.Results.ok;

@Singleton
public class AdminController extends Controller {

    private AdminService adminService;

    @Inject
    public AdminController(AdminService adminService)
    {
        this.adminService = adminService;
    }

    public Result loginRegister(Http.Request request) {
        JsonNode response;
        LoginRegisterDetailsRequest loginDetailsRequest = LoginRegisterDetailsRequest.build(request.body().asJson());
        Boolean isSaved = Boolean.FALSE;
        try {
             isSaved = adminService.setLoginCredentials(loginDetailsRequest);
        }catch (Exception ex) {
             response = Json.toJson(new TrainCustomException(500,"Process error",ex.getMessage()));
        }
        response = Json.toJson(new SuccessResponse(isSaved));
        return ok(response);
    }

    public Result login(Http.Request request) {
        JsonNode response;
        LoginRequest loginRequest = LoginRequest.build(request.body().asJson());
        Boolean isLoggedInUser = Boolean.FALSE;
        try {
            isLoggedInUser = adminService.isUser(loginRequest);
        }catch(Exception ex) {
            response = Json.toJson(new TrainCustomException(500,"Processing Error","error while matching the user credentials"));
        }
        response =Json.toJson(new SuccessResponse(isLoggedInUser));
        return ok(response);
    }

}

package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.AdminService;
import skeletons.request.RegisterUserDetailsRequest;
import skeletons.request.LoginRequest;
import skeletons.response.ExceptionResponse;
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
        RegisterUserDetailsRequest loginDetailsRequest = RegisterUserDetailsRequest.build(request.body().asJson());
        if(!RegisterUserDetailsRequest.validate(loginDetailsRequest)) {
            return ok(Json.toJson(new ExceptionResponse(500,"Invalid Input", RegisterUserDetailsRequest.validationError)));
        }
        Boolean isSaved = Boolean.FALSE;
        try {
             isSaved = adminService.createUser(loginDetailsRequest);
             response = Json.toJson(new SuccessResponse(isSaved));
        }catch (Exception ex) {
             response = Json.toJson(new ExceptionResponse(500,"Process error",ex.toString()));
        }
        return ok(response);
    }

    public Result login(Http.Request request) {
        JsonNode response;
        LoginRequest loginRequest = LoginRequest.build(request.body().asJson());
        if(!LoginRequest.validate(loginRequest)) {
            return ok(Json.toJson(new ExceptionResponse(500,"Invalid Input",LoginRequest.validationError)));
        }
        Boolean isLoggedInUser = Boolean.FALSE;
        try {
            isLoggedInUser = adminService.isUser(loginRequest);
        }catch(Exception ex) {
            response = Json.toJson(new ExceptionResponse(500,"Processing Error",ex.getMessage()));
        }
        response =Json.toJson(new SuccessResponse(isLoggedInUser));
        return ok(response);
    }


    //:TODO
    //why Eolutions module is there in play directory
    //
}

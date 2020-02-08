package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import context.NormalExecutionContext;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;


@Singleton
public class AdminController extends Controller {

    private final NormalExecutionContext normalExecutionContext;
    private AdminService adminService;

    @Inject
    public AdminController(AdminService adminService,
                           NormalExecutionContext normalExecutionContext)
    {
        this.adminService = adminService;
        this.normalExecutionContext = normalExecutionContext;
    }

    public CompletionStage<Result> loginRegister(Http.Request request) {
        CompletionStage<Result> responseAsync;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        responseAsync = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            RegisterUserDetailsRequest loginDetailsRequest = RegisterUserDetailsRequest.build(request.body().asJson());
            if (!RegisterUserDetailsRequest.validate(loginDetailsRequest)) {
                return ok(Json.toJson(new ExceptionResponse(500, "Invalid Input", RegisterUserDetailsRequest.validationError)));
            }
            Boolean isSaved = Boolean.FALSE;
            try {
                isSaved = adminService.createUser(loginDetailsRequest);
                response = Json.toJson(new SuccessResponse(isSaved));
            } catch (Exception ex) {
                response = Json.toJson(new ExceptionResponse(500, "Process error", ex.toString()));
            }
            return ok(response);
        },executor);
        return responseAsync;
    }

    public CompletionStage<Result> login(Http.Request request) {
        CompletionStage<Result> result;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        result = CompletableFuture.supplyAsync(()-> {
            JsonNode response;
            LoginRequest loginRequest = LoginRequest.build(request.body().asJson());
            if (!LoginRequest.validate(loginRequest)) {
                return ok(Json.toJson(new ExceptionResponse(500, "Invalid Input", LoginRequest.validationError)));
            }
            Boolean isLoggedInUser = Boolean.FALSE;
            try {
                isLoggedInUser = adminService.isUser(loginRequest);
            } catch (Exception ex) {
                response = Json.toJson(new ExceptionResponse(500, "Processing Error", ex.getMessage()));
            }
            response = Json.toJson(new SuccessResponse(isLoggedInUser));
            return ok(response);
        },executor);
        return result;
    }


    //:TODO
    //why Eolutions module is there in play directory
    //
}

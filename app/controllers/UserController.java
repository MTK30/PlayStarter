package controllers;

import context.NormalExecutionContext;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.mvc.Result;
import scala.concurrent.ExecutionContext;
import services.UserService;
import skeletons.response.ExceptionResponse;
import skeletons.response.SuccessResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

import static play.mvc.Results.ok;

@Singleton
public class UserController {

    private NormalExecutionContext normalExecutionContext;
    private UserService userService;

    @Inject
    public UserController(NormalExecutionContext normalExecutionContext,UserService userService) {
        this.normalExecutionContext = normalExecutionContext;
        this.userService = userService;
    }

    public CompletionStage<Result> getAlreadyAnswered(final Long userId) {
        CompletionStage<Result> result;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        result = CompletableFuture.supplyAsync(()->{
            if(userId != null) {
                try {
                    return ok(Json.toJson(new SuccessResponse(userService.getAlreadyAnsweredQuestions(userId))));
                }
                catch(Exception ex){
                    return ok(Json.toJson(new ExceptionResponse(500,"Processing Error",ex.getMessage())));
                }
            }else {
                return ok(Json.toJson(new ExceptionResponse(500,"Invalid Request","userid is Mandatory")));
            }
        },executor);
        return result;
    }

    public CompletionStage<Result> userCanAnswer(final Long userId) {
        CompletionStage<Result> result;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        result = CompletableFuture.supplyAsync(() -> {
            if(userId != null) {
                try {
                    return ok(Json.toJson(new SuccessResponse(userService.canAnswer(userId))));
                } catch (Exception ex) {
                    return ok(Json.toJson(new ExceptionResponse(500,"Processing Error",ex.getMessage())));
                }
            } else {
                return ok(Json.toJson(new ExceptionResponse(500,"Invalid Request","userid is Mandatory")));
            }
        },executor);
        return result;
    }
}

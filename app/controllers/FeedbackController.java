package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import context.NormalExecutionContext;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.mvc.Http;
import play.mvc.Result;
import services.FeedBackService;
import skeletons.request.FeedbackRequest;
import skeletons.response.ExceptionResponse;
import skeletons.response.SuccessResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

import static play.mvc.Results.ok;

@Singleton
public class FeedbackController {

    private NormalExecutionContext normalExecutionContext;
    private FeedBackService feedBackService;

    @Inject
    public FeedbackController(NormalExecutionContext normalExecutionContext
                              ,FeedBackService feedBackService) {
        this.normalExecutionContext = normalExecutionContext;
        this.feedBackService = feedBackService;
    }

    public CompletionStage<Result> updateFeedback(Http.Request request) {
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        CompletionStage<Result> result;
        result = CompletableFuture.supplyAsync(() -> {
            JsonNode jsonNode;
            FeedbackRequest feedbackRequest = FeedbackRequest.build(request.body().asJson());
            if(!FeedbackRequest.validate(feedbackRequest)) {
                return ok(Json.toJson(new ExceptionResponse(500,"Validation Error",feedbackRequest.getValidationError())));
            }
            else {
                return ok(Json.toJson(new SuccessResponse(feedBackService.updateFeedBack(feedbackRequest))));
            }
        },executor);
        return result;
    }
}

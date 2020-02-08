package controllers;

import akka.http.scaladsl.Http$;
import akka.stream.impl.QueueSource;
import com.fasterxml.jackson.databind.JsonNode;
import context.NormalExecutionContext;
import play.libs.Json;
import play.libs.concurrent.HttpExecution;
import play.mvc.Http;
import play.mvc.Result;
import services.QandAService;
import skeletons.request.AnswerRequest;
import skeletons.request.QuestionRequest;
import skeletons.response.ExceptionResponse;
import skeletons.response.SuccessResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

import static play.mvc.Results.ok;

@Singleton
public class QandAController {

    private QandAService qandAService;
    private NormalExecutionContext normalExecutionContext;

    @Inject
    public QandAController(QandAService qandAService,
                           NormalExecutionContext normalExecutionContext) {
        this.qandAService = qandAService;
        this.normalExecutionContext = normalExecutionContext;
    }

    /**
     * EndPoint to insert an new Question into the system
     * @param httpRequest
     * @return
     */
    public CompletionStage<Result> insertQuestion(Http.Request httpRequest) {
        CompletionStage<Result> result;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        result = CompletableFuture.supplyAsync(()->{
        JsonNode response;
        JsonNode jsonNode = httpRequest.body().asJson();
        QuestionRequest questionRequest = QuestionRequest.build(jsonNode);
        if(QuestionRequest.validate(questionRequest)) {
            try {
                response = Json.toJson(new SuccessResponse(qandAService.addQuestion(questionRequest)));
            } catch (Exception ex) {
                response = Json.toJson(new ExceptionResponse(500,"Processing Eroor",ex.getLocalizedMessage()));
            }
        }
        else {
            response = Json.toJson(new ExceptionResponse(500,"Invalid Request",QuestionRequest.validationError));
        }
        return ok(response);
        },executor);
        return result;
    }

    /**
     * End Point to Insert a new Answer to the Question into the system
     * @param httpRequest
     * @return
     */
    public CompletionStage<Result> answerQuestion(Http.Request httpRequest) {
        CompletionStage<Result> result;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        result = CompletableFuture.supplyAsync(()-> {
        JsonNode response;
        JsonNode jsonNode = httpRequest.body().asJson();
        AnswerRequest answerRequest = AnswerRequest.build(jsonNode);
        if(AnswerRequest.validate(answerRequest)){
            try {
                response = Json.toJson(new SuccessResponse(qandAService.addAnswer(answerRequest)));
            } catch (Exception ex) {
                response = Json.toJson(new ExceptionResponse(500,"Processing Error",ex.getLocalizedMessage()));
            }
        }else {
            response = Json.toJson(new ExceptionResponse(500,"Invalid Request",AnswerRequest.validationError));
        }
        return ok(Json.toJson(new SuccessResponse(true)));
        },executor);
        return  result;
    }


    //:TODO
    //Implement "From"
    public CompletionStage<Result> getRecentlyAddedQuestions() {
        CompletionStage<Result> result;
        Executor executor = HttpExecution.fromThread((Executor) normalExecutionContext);
        result = CompletableFuture.supplyAsync(()->{
        try {
            return ok(Json.toJson((new SuccessResponse(qandAService.getRecentQuestion()))));
        }
        catch (Exception ex) {
            return ok(Json.toJson(new ExceptionResponse(500,"Processing Error",ex.getLocalizedMessage())));
        }
        },executor);
        return result;
    }


    //:TODO
    //Implement "From" and "to"
    public CompletionStage<Result> getRecentQandA() {
        CompletionStage<Result> result;
        Executor executor = HttpExecution.fromThread((Executor)normalExecutionContext);
        result = CompletableFuture.supplyAsync(()-> {
        try {
            return ok(Json.toJson(new SuccessResponse(qandAService.getRecentQandA())));
        } catch (Exception ex) {
            return ok(Json.toJson(new ExceptionResponse(500,"Processing Error",ex.getLocalizedMessage())));
        }
        },executor);
        return result;
    }
}

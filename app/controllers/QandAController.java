package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import services.QandAService;
import skeletons.request.AnswerRequest;
import skeletons.request.QuestionRequest;
import skeletons.response.ExceptionResponse;
import skeletons.response.SuccessResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import static play.mvc.Results.ok;

@Singleton
public class QandAController {

    private QandAService qandAService;

    @Inject
    public QandAController(QandAService qandAService) {
        this.qandAService = qandAService;
    }

    /**
     * EndPoint to insert an new Question into the system
     * @param httpRequest
     * @return
     */
    public Result insertQuestion(Http.Request httpRequest) {
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
    }

    /**
     * End Point to Insert a new Answer to the Question into the system
     * @param httpRequest
     * @return
     */
    public Result answerQuestion(Http.Request httpRequest) {
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
    }


    //:TODO
    //Implement "From"
    public Result getRecentlyAddedQuestions() {
        try {
            return ok(Json.toJson((new SuccessResponse(qandAService.getRecentQuestion()))));
        }
        catch (Exception ex) {
            return ok(Json.toJson(new ExceptionResponse(500,"Processing Error",ex.getLocalizedMessage())));
        }
    }


    //:TODO
    //Implement "From" and "to"
    public Result getRecentQandA() {
        try {
            return ok(Json.toJson(new SuccessResponse(qandAService.getRecentQandA())));
        } catch (Exception ex) {
            return ok(Json.toJson(new ExceptionResponse(500,"Processing Error",ex.getLocalizedMessage())));
        }
    }
}

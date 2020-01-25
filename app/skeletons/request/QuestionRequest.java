package skeletons.request;

import akka.japi.Util;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import utils.Utils;

@Setter
@Getter
public class QuestionRequest {

    private Long userId;

    private String question;

    private String tagging;

    public static  String validationError;

    public static QuestionRequest build(JsonNode jsonNode) {
        return (QuestionRequest) Utils.converObjectTORequest(jsonNode,QuestionRequest.class);
    }

    public static Boolean validate(QuestionRequest questionRequest) {
        Boolean isValid = Boolean.TRUE;
        if(questionRequest.getQuestion() == null) {
            QuestionRequest.validationError = "Question cannot be null";
            isValid = Boolean.FALSE;
        }
        else if(questionRequest.getTagging() == null ) {
            QuestionRequest.validationError = "Tagging the specfic is madatory";
            isValid = Boolean.FALSE;
        }
        else if (questionRequest.getUserId() == null) {
            QuestionRequest.validationError = "User Id is Mandatory";
            isValid = Boolean.FALSE;
        }
        return isValid;
    }

}

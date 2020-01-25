package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import utils.Utils;

@Getter
@Setter
public class AnswerRequest {

    private Long userId;

    private Long questionId;

    private String answer;

    public static String validationError;

    public static AnswerRequest build(JsonNode jsonNode) {
        return (AnswerRequest) Utils.converObjectTORequest(jsonNode,AnswerRequest.class);
    }

    public static Boolean validate(AnswerRequest answerRequest) {
        Boolean isValid = Boolean.TRUE;
        if(answerRequest.getUserId() == null) {
            AnswerRequest.validationError = "User Id is mandatory";
            isValid = Boolean.FALSE;
        }
        else if(answerRequest.getAnswer() == null) {
            AnswerRequest.validationError = "Answer is mandatory Field";
            isValid = Boolean.FALSE;
        }
        else if (answerRequest.getQuestionId() == null ) {
            AnswerRequest.validationError = "Question Id is Mandatory";
            isValid = Boolean.FALSE;
        }
        return isValid;
    }
}

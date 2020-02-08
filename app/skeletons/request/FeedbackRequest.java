package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import utils.Utils;

@Getter
@Setter
public class FeedbackRequest {

    private Long entityId;

    private String entityType;

    private Integer isLikedDislike;

    private Long userId;

    private String validationError;

    public static FeedbackRequest build(JsonNode jsonNode) {
        return (FeedbackRequest) Utils.converObjectTORequest(jsonNode,FeedbackRequest.class);
    }

    public static Boolean validate(FeedbackRequest feedbackRequest){
        Boolean isValidRequest = Boolean.TRUE;
        if(feedbackRequest.getEntityId() == null || feedbackRequest.getEntityType() == null) {
            isValidRequest = Boolean.FALSE;
            feedbackRequest.validationError = "Entity Info Mandatory";
        }
        else if (feedbackRequest.getUserId() == null) {
            isValidRequest = Boolean.FALSE;
            feedbackRequest.validationError = "User Id is mandatory";
        }
        return isValidRequest;
    }
}

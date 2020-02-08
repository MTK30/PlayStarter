package skeletons.response;

import lombok.Getter;
import lombok.Setter;
import models.Question;

import java.util.List;

@Getter
@Setter
public class UserCanAnswerResponse {

    private String question;

    private Long questionId;

}

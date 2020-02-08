package services;

import enums.EntityType;
import models.Answer;
import models.Feedback;
import models.Question;
import models.User;
import repositories.AnswerRepository;
import repositories.FeedBackRepository;
import repositories.QuestionRepository;
import repositories.UserRepository;
import skeletons.request.FeedbackRequest;
import skeletons.response.FeedBackResponse;
import utils.Constants;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FeedBackService {

    private FeedBackRepository feedBackRepository;
    private UserRepository userRepository;
    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;
    private final String NO_USER_RESPONSE = "No such User Present";
    private final String NO_SUCH_ENTITY = "No such Entity";
    private final String SuccessFull_Message = "Operation SucessFull";

    @Inject
    public FeedBackService(UserRepository userRepository,AnswerRepository answerRepository
                            ,QuestionRepository questionRepository,FeedBackRepository feedBackRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.feedBackRepository =feedBackRepository;
    }
    public FeedBackResponse updateFeedBack(FeedbackRequest feedbackRequest){
        FeedBackResponse feedBackResponse = new FeedBackResponse();
        User user = userRepository.getUserById(feedbackRequest.getUserId());
        Answer answer = null;
        Question question = null;
        if(user == null) {
            feedBackResponse.setIsUpdated(Boolean.FALSE);
            feedBackResponse.setUpdateMessage(NO_USER_RESPONSE);
        }
        else {
            if(feedbackRequest.getEntityType().equals(EntityType.Question.name()) ||feedbackRequest.getEntityType().equals(EntityType.question.name())) {
                question = questionRepository.getQuestionById(feedbackRequest.getEntityId());
            }
            else if(feedbackRequest.getEntityType().equals(EntityType.Answer.name()) ||feedbackRequest.getEntityType().equals(EntityType.answer.name())) {
                answer = answerRepository.getAnswerById(feedbackRequest.getEntityId());
            }
            if (question == null && answer == null) {
                feedBackResponse.setIsUpdated(Boolean.FALSE);
                feedBackResponse.setUpdateMessage(NO_SUCH_ENTITY);
            }
            Feedback feedback = feedBackRepository.getFeedBack(feedbackRequest.getEntityType(),feedbackRequest.getEntityId(),feedbackRequest.getUserId());
            if(feedback == null) {
                feedback = new Feedback();
                feedback.setUserId(feedbackRequest.getUserId());
                feedback.setEntityId(feedbackRequest.getEntityId());
                feedback.setEntityType(feedbackRequest.getEntityType());
            }
            feedback.setLikeDislike(feedbackRequest.getIsLikedDislike());
            if(answer != null) {
                if(feedbackRequest.getIsLikedDislike() == Constants.ONE)
                    answer.setLikeCount(answer.getLikeCount() + 1 );
                else
                    answer.setDisLikeCount(answer.getDisLikeCount() + 1);
                answerRepository.save(answer);
            }
            else if (question != null) {
                if(feedbackRequest.getIsLikedDislike() == Constants.ONE)
                    question.setLikeCount(question.getLikeCount() + 1 );
                else
                    question.setDisLikeCount(question.getDisLikeCount() + 1);
                questionRepository.save(question);
            }
            feedBackResponse.setIsUpdated(Boolean.TRUE);
            feedBackResponse.setUpdateMessage(SuccessFull_Message);
            feedBackRepository.save(feedback);
        }
        return feedBackResponse;
    }
}

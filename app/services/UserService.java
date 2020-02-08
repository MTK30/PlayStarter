package services;
import models.Answer;
import models.Question;
import models.User;
import repositories.AnswerRepository;
import repositories.QuestionRepository;
import repositories.UserRepository;
import skeletons.response.QandAResponse;
import skeletons.response.UserCanAnswerResponse;
import utils.Utils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class UserService {

    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;
    private UserRepository userRepository;

    @Inject
    public UserService(AnswerRepository answerRepository,QuestionRepository questionRepository,
                       UserRepository userRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    public List<QandAResponse> getAlreadyAnsweredQuestions(Long userId) {
        List<Answer> answers = answerRepository.getAnswerByUserId(userId);
        List<QandAResponse> qandAResponses = new ArrayList<>();
        if (!Utils.isEmpty(answers)) {
            answers.forEach(
                    answer -> {
                        Question question = questionRepository.getQuestionById(answer.getQuestionId());
                        QandAResponse qandAResponse = new QandAResponse();
                        qandAResponse.setQuestion(question.getQuestion());
                        qandAResponse.setAnswer(answer.getAnswer());
                        qandAResponses.add(qandAResponse);
                    }
            );
        }
        return qandAResponses;
    }

    public List<UserCanAnswerResponse> canAnswer(Long userId) {
        User user = userRepository.getUserById(userId);
        String taggingStrings = user.getCanAnswer();
        List<UserCanAnswerResponse> userCanAnswerResponses = new ArrayList<>();
        List<String> taggingAttributes = Arrays.asList(taggingStrings.split(","));
        taggingAttributes.forEach(
                tagging->{
                    List<Question> questionofSpecificTag = questionRepository.getQuestionCanAnswer(tagging);
                    questionofSpecificTag.forEach(
                            question -> {
                                UserCanAnswerResponse userCanAnswerResponse = new UserCanAnswerResponse();
                                userCanAnswerResponse.setQuestion(question.getQuestion());
                                userCanAnswerResponse.setQuestionId(question.getId());
                                userCanAnswerResponses.add(userCanAnswerResponse);
                            }
                    );

                }
        );
        return userCanAnswerResponses;
    }
}

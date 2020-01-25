package services;

import models.Answer;
import models.Question;
import models.User;
import repositories.AnswerRepository;
import repositories.QuestionRepository;
import repositories.UserRepository;
import skeletons.exception.CareerCarrierException;
import skeletons.request.AnswerRequest;
import skeletons.request.QuestionRequest;
import skeletons.response.QandAResponse;
import skeletons.response.RecentQuestionResponse;
import utils.Utils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class QandAService {

    private UserRepository userRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @Inject
    public QandAService(UserRepository userRepository, QuestionRepository questionRepository,
                        AnswerRepository answerRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public Boolean addQuestion(QuestionRequest questionRequest) {
        Boolean isSaved;
        User user;
        try {
            user = userRepository.getUserById(questionRequest.getUserId());
        } catch (Exception ex) {
            throw new CareerCarrierException(500,"Persistance Exception",ex.getMessage());
        }
        if(null == user) {
            throw new CareerCarrierException(500,"User with Id doesnt exist","Invalid User credentials");
        }
        Question question = new Question();
        question.setUserId(questionRequest.getUserId());
        question.setQuestion(questionRequest.getQuestion());
        question.setTagging(questionRequest.getTagging());
        question.setCreationDate(new Date());
        try {
            questionRepository.save(question);
            isSaved = Boolean.TRUE;
        } catch (Exception ex) {
            throw new CareerCarrierException(500,"Persistence Exception",ex.getMessage());
        }
        return isSaved;
    }

    public Boolean addAnswer(AnswerRequest answerRequest) {
        Boolean isSaved = Boolean.FALSE;
        if(isValidAnswer(answerRequest)) {
            Answer answer = new Answer();
            answer.setUserid(answerRequest.getUserId());
            answer.setQuestionId(answerRequest.getQuestionId());
            answer.setAnswer(answerRequest.getAnswer());
            answer.setDateOfCreation(new Date());
            answer.setDateOfUpdate(new Date());
            try {
                answerRepository.save(answer);
            } catch (Exception ex) {
                throw new CareerCarrierException(500,"Persistence Exception",ex.getMessage());
            }
            isSaved = Boolean.TRUE;
        }
        return false;
    }

    /**
     * Method Checks the validity of Answer
     * @param answerRequest
     * @return Boolean
     */
    private Boolean isValidAnswer(AnswerRequest answerRequest) {
        Boolean isValidAnswer = Boolean.TRUE;
        User user = userRepository.getUserById(answerRequest.getUserId());
        Question question = questionRepository.getQuestionById(answerRequest.getQuestionId());
        if(user == null || question == null) {
            isValidAnswer = Boolean.FALSE;
        }
        return isValidAnswer;
    }

    /**
     * to fetch recent Question that is being asked
     * @return List<Question>
     */
    public List<RecentQuestionResponse> getRecentQuestion() {
        List<Question> questions;
        try {
            questions = questionRepository.getQuestions();
        } catch(Exception ex) {
            throw new CareerCarrierException(500,"Persistence Exception",ex.getMessage());
        }
        List<RecentQuestionResponse> recentQuestionResponses = new ArrayList<>();
        questions.forEach(
                question -> {
                    RecentQuestionResponse recentQuestionResponse = (RecentQuestionResponse) Utils.converObjectTORequest(question,RecentQuestionResponse.class);
                    recentQuestionResponses.add(recentQuestionResponse);
                }
        );
        return recentQuestionResponses;
    }

    /**
     * fetch recent Question and Answer
     * @return List<QandAResponse>
     */
    public List<QandAResponse> getRecentQandA() {
        List<QandAResponse> qandAResponses;
        List<Answer> answers = null;
        try {
            answers = answerRepository.getRecentAnswer();
        }
        catch (Exception ex) {
            throw new CareerCarrierException(500,"Persistence Exception",ex.getMessage());
        }
        Set<Long> questionIds = new HashSet<>();
        qandAResponses = new ArrayList<>();
        if(answers != null) {
            answers.forEach(
                answer -> {
                    if(questionIds.add(answer.getQuestionId())){
                        Question question = questionRepository.getQuestionById(answer.getQuestionId());
                        QandAResponse qandAResponse = new QandAResponse();
                            qandAResponse.setAnswer(answer.getAnswer());
                            qandAResponse.setQuestion(question.getQuestion());
                            qandAResponses.add(qandAResponse);
                        }
                    }
                );
            }
        return qandAResponses;
    }

}

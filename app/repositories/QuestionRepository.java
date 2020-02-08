package repositories;

import models.Question;
import utils.Constants;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class QuestionRepository extends EbeanRepository<Question, Long> {

    public QuestionRepository() {
        super(Question.class);
    }

    public Question getQuestionById(Long id){
        return getCareerCarrierReadctx().find(Question.class)
                .where()
                .eq("id",id)
                .findOne();
    }

    public List<Question> getQuestions() {
        return getCareerCarrierReadctx().find(Question.class)
                .order()
                .desc("date_of_question")
                .setMaxRows(Constants.maxQuestionInRecent)
                .findList();
    }

    public List<Question> getQuestionCanAnswer(String canAnswer) {
        return getCareerCarrierReadctx().find(Question.class)
                .where()
                .like("tagging",'%'+canAnswer+'%')
                .findList();
    }

}

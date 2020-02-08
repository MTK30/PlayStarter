package repositories;

import models.Answer;
import utils.Constants;

import javax.inject.Singleton;
import javax.security.auth.login.AccountNotFoundException;
import java.util.Date;
import java.util.List;

@Singleton
public class AnswerRepository extends EbeanRepository<Answer,Long> {

    public AnswerRepository() {
        super(Answer.class);
    }

    public List<Answer> getRecentAnswer() {
        return  getCareerCarrierReadctx().find(Answer.class)
                .order()
                .desc("date_of_update")
                .setMaxRows(Constants.maxAnswerInRecent)
                .findList();
    }

    public Answer getAnswerById(Long id) {
        return getCareerCarrierReadctx().find(Answer.class)
                .where()
                .eq("id",id)
                .findOne();
    }

    public List<Answer> getAnswerByUserId(Long userId) {
        return getCareerCarrierReadctx().find(Answer.class)
                .where()
                .eq("user_id",userId)
                .findList();
    }
}

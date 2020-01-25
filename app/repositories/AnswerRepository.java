package repositories;

import models.Answer;
import utils.Constants;

import javax.inject.Singleton;
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

}

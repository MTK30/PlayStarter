package repositories;

import models.Feedback;

import javax.inject.Singleton;

@Singleton
public class FeedBackRepository extends EbeanRepository<Feedback,Long> {
    public FeedBackRepository() {
        super(Feedback.class);
    }

    public Feedback getFeedBack(String entityType,Long entityId,Long userId) {
        return getCareerCarrierReadctx().find(Feedback.class)
                .where()
                .eq("user_id",userId)
                .eq("entity_id",entityId)
                .eq("entity_type",entityType)
                .findOne();
    }

}

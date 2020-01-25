package repositories;


import models.User;

import javax.inject.Singleton;

@Singleton
public class UserRepository extends EbeanRepository<User,Long> {

    public UserRepository() {
            super(User.class);
    }

    public User getUserById(Long id) {
        return getCareerCarrierReadctx().find(User.class)
                .where()
                .eq("id",id)
                .findOne();
    }
}
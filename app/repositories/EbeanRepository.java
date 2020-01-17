package repositories;

import io.ebean.EbeanServer;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author MTK
 * @data 13/01/2020
 */
public class EbeanRepository<T ,ID extends Serializable> {
    private final EbeanServer careerCarrierReadctx;
    private final EbeanServer careerCarrierWritectx;
    private final Class<T> persistenClass;

    @Inject
    public EbeanRepository(Class<T> persistenClass) {
        this.careerCarrierReadctx = io.ebean.Ebean.getServer("career_carrier_read");
        this.careerCarrierWritectx = io.ebean.Ebean.getServer("career_carrier_write");
        this.persistenClass = persistenClass;
    }

    public EbeanServer getCareerCarrierReadctx() {
        return careerCarrierReadctx;
    }

    public EbeanServer getCareerCarrierWritectx() {
        return careerCarrierWritectx;
    }

    public <S extends T> void save(S entity) {
        careerCarrierWritectx.save(entity);
    }

    public <S extends T> void saveAll(Collection<S> entities) {
        careerCarrierWritectx.saveAll(entities);
    }

}

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
    private final EbeanServer cabSharingReadctx;
    private final EbeanServer cabSharingWritectx;
    private final Class<T> persistenClass;

    @Inject
    public EbeanRepository(Class<T> persistenClass) {
        this.cabSharingReadctx = io.ebean.Ebean.getServer("CabSharing_read");
        this.cabSharingWritectx = io.ebean.Ebean.getServer("CabSharing_write");
        this.persistenClass = persistenClass;
    }

    public EbeanServer getCabSharingReadctx() {
        return cabSharingReadctx;
    }

    public EbeanServer getCabSharingWritectx() {
        return cabSharingWritectx;
    }

    public <S extends T> void save(S entity) {
        cabSharingWritectx.save(entity);
    }

    public <S extends T> void saveAll(Collection<S> entities) {
        cabSharingWritectx.saveAll(entities);
    }

}

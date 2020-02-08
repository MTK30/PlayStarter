package models;

import enums.EntityType;
import io.ebean.Model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Entity
@Table(name="feedback")
public class Feedback extends Model implements Serializable {

    @Id
    @Column(name="id")
    private Long id;

    @Setter
    @Column(name="user_id")
    private Long userId;

    @Setter
    @Column(name="entity_id")
    private Long entityId;

    @Setter
    @Column(name="entity_type")
    private String entityType;

    @Setter
    @Column(name="like_dislike")
    private Integer likeDislike;
}

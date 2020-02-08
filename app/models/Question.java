package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.ebean.Model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Entity
@Table(name = "question")
public class Question extends Model implements Serializable {

    @Id
    @Column(name="id")
    private Long id;

    @Setter
    @Column(name="user_id")
    private Long userId;

    @Setter
    @Column(name="question")
    private String question;

    @Setter
    @Column(name="tagging")
    private String tagging;

    @Setter
    @Column(name="date_of_question")
    private Date creationDate;

    @Setter
    @Column(name="like_count")
    private Integer likeCount;

    @Setter
    @Column(name="dislike_count")
    private Integer disLikeCount;

}

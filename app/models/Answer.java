package models;

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
@Table(name = "answer")
public class Answer extends Model implements Serializable {

    @Id
    @Column(name= "id")
    private Long id;

    @Setter
    @Column(name= "user_id")
    private Long userid;

    @Setter
    @Column(name= "question_id")
    private Long questionId;

    @Setter
    @Column(name= "answer")
    private String answer;

    @Setter
    @Column(name= "date_of_answer")
    private Date dateOfCreation;

    @Setter
    @Column(name = "date_of_update")
    private Date dateOfUpdate;

}

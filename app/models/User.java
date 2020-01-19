package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "name")
    private String name;

    @Setter
    @Column(name ="mobile")
    private Long moblieNo;

    @Setter
    @Column(name ="dob")
    private Date dob;

    @Setter
    @Column(name ="education_qualification")
    private String educationQualification;

    @Setter
    @Column(name = "professional_position")
    private String professionalPosition;

    @Setter
    @Column(name ="field_of_expertise")
    private String fieldOfExpertise;

    @Setter
    @Column(name ="about")
    private String about;

    @Setter
    @Column(name ="can_answer")
    private String canAnswer;
}

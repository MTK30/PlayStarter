package models;

import io.ebean.Model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "login_credentials")
@Entity
public class LoginDetails extends Model implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pwd")
    private String md5Pwd;

    @Column(name = "mobile")
    private Long mobileNo;

}

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
@Entity
@Table(name = "login_credentials")
public class LoginDetails extends Model implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "user_id")
    private Long userId;

    @Setter
    @Column(name = "user_name")
    private String userName;

    @Setter
    @Column(name = "pwd")
    private String md5Pwd;

}

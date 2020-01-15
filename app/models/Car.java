package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Entity
@Table(name = "Car")
public class Car extends Model implements Serializable {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name ="cab_type")
    private String carType;

    @Column(name="cab_accomodate")
    private Integer cabAccomodate;

}

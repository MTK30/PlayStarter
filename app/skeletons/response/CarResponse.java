package skeletons.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

/**
 *  * @author M Tarun Kumar
 *   * @date 15/01/2019
 *    */
@Getter
@Setter
public class CarResponse {

    private String name;

    private String carType;

    private Integer cabAccomodate;
}
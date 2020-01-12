package skeletons;

import lombok.Getter;

/**
 * @author  MTK
 * @date 13/01/2019
 */
@Getter
public class SucessResponse {
    private Integer statusCode;
    private String description;
    private Object data;

    public SucessResponse(Object data) {
        this.data = data;
        this.statusCode = 200;
        this.description = "success";
    }
}

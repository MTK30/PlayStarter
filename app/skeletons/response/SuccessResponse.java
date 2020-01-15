package skeletons.response;

import lombok.Getter;
/**
 * @author  MTK
 * @date 13/01/2019
 */
@Getter
public class SuccessResponse {
    private Integer statusCode;
    private String description;
    private Object data;

    public SuccessResponse(Object data) {
        this.data = data;
        this.statusCode = 200;
        this.description = "success";
    }
}


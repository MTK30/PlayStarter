package skeletons.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

    private Integer statusCode;

    private String description;

    private String data;

    public ExceptionResponse(Integer statusCode,String description,String data) {
        this.statusCode = statusCode;
        this.description = description;
        this.data = data;
    }
}

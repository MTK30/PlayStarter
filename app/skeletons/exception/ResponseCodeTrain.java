package skeletons.exception;

import lombok.Getter;

@Getter
public class ResponseCodeTrain implements ResponseCode{

    private Integer responseCode;
    private String responseDescription;
    private String responseType;

    public ResponseCodeTrain(Integer responseCode,String responseDescription,String responseType) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.responseType = responseType;
    }
}

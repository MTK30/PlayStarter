package skeletons.exception;

import play.libs.Json;

public class CareerCarrierException extends RuntimeException {

    private ResponseCode responseCode;

    public CareerCarrierException(ResponseCode responseCode) {
        super(getResponseCode(responseCode));
        this.responseCode = responseCode;
    }

    public CareerCarrierException(Integer code, String type, String description) {
        this(new ResponseCodeTrain(code,type,description));
    }
    public static String getResponseCode(ResponseCode responseCode) {
        return Json.toJson(responseCode).toString();
    }

    public  ResponseCode getResponseCode() {
        return responseCode;
    }
}

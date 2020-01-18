package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import utils.Utils;

@Getter
@Setter
public class LoginRequest {
    private String userName;
    private String pwd;
    public static String validationError;

    public static LoginRequest build(JsonNode jsonNode) {
        return (LoginRequest) Utils.converObjectTORequest(jsonNode,LoginRequest.class);
    }

    public static Boolean validate(LoginRequest loginRequest) {
        Boolean isValid = Boolean.TRUE;
        if(loginRequest.getUserName() == null) {
            validationError = "userName is mandatory";
            isValid = Boolean.FALSE;
        }
        else if(loginRequest.getPwd() == null) {
            validationError = "Password Field is mandatory";
            isValid = Boolean.TRUE;
        }
        return isValid;
    }

}

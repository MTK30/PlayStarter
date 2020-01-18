package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import utils.Utils;

@Getter
@Setter
public class LoginRegisterDetailsRequest {

    private String userName;

    private String pwd;

    private Long mobileNo;

    public static String validationError;

    public static LoginRegisterDetailsRequest build (JsonNode jsonNode) {
        return (LoginRegisterDetailsRequest) Utils.converObjectTORequest(jsonNode, LoginRegisterDetailsRequest.class);
    }

    public static Boolean validate(LoginRegisterDetailsRequest loginRegisterDetailsRequest) {
        Boolean isValid = Boolean.TRUE;
        if( null == loginRegisterDetailsRequest.getUserName()) {
            LoginRegisterDetailsRequest.validationError = "User Name is Mandatory";
            isValid = Boolean.FALSE;
        }
        else if (null == loginRegisterDetailsRequest.getPwd()) {
            LoginRegisterDetailsRequest.validationError = "Pwd Field is Mandatory";
            isValid = Boolean.FALSE;
        }
        else if ( null == loginRegisterDetailsRequest.getMobileNo()) {
            LoginRegisterDetailsRequest.validationError = "Mobile no is mandatory";
            isValid = Boolean.FALSE;
        }
        return isValid;
    }
}

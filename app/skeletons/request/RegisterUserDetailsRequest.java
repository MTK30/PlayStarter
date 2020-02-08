package skeletons.request;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import utils.Utils;

@Getter
@Setter
public class RegisterUserDetailsRequest {

    private String name;

    private Long mobileNo;

    private String userName;

    private String pwd;

    private String  dob;

    private String educationQualification;

    private String specialization;

    private String professionalPosition;

    private String fieldOfExpertise;

    private String aboutUser;

    private String canAnswer;

    public static String validationError;

    public static RegisterUserDetailsRequest build (JsonNode jsonNode) {
        return (RegisterUserDetailsRequest) Utils.converObjectTORequest(jsonNode, RegisterUserDetailsRequest.class);
    }

    public static Boolean validate(RegisterUserDetailsRequest loginRegisterDetailsRequest) {
        Boolean isValid = Boolean.TRUE;
        if( null == loginRegisterDetailsRequest.getUserName()) {
            RegisterUserDetailsRequest.validationError = "User Name is Mandatory";
            isValid = Boolean.FALSE;
        }
        else if (null == loginRegisterDetailsRequest.getPwd()) {
            RegisterUserDetailsRequest.validationError = "Pwd Field is Mandatory";
            isValid = Boolean.FALSE;
        }
        else if ( null == loginRegisterDetailsRequest.getMobileNo()) {
            RegisterUserDetailsRequest.validationError = "Mobile no is mandatory";
            isValid = Boolean.FALSE;
        }
        else if( null == loginRegisterDetailsRequest.getName()) {
            RegisterUserDetailsRequest.validationError = "Name madatiory Field";
            isValid = Boolean.FALSE;
        }
        else if (null == loginRegisterDetailsRequest.getEducationQualification()) {
            RegisterUserDetailsRequest.validationError = "Education Qualification";
            isValid = Boolean.FALSE;
        }
        return isValid;
    }
}

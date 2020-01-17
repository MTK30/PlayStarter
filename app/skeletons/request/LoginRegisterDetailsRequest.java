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

    public static LoginRegisterDetailsRequest build (JsonNode jsonNode) {
        return (LoginRegisterDetailsRequest) Utils.converObjectTORequest(jsonNode, LoginRegisterDetailsRequest.class);
    }

}

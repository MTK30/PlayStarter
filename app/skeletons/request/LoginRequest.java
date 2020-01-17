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

    public static LoginRequest build(JsonNode jsonNode) {
        return (LoginRequest) Utils.converObjectTORequest(jsonNode,LoginRequest.class);
    }
}

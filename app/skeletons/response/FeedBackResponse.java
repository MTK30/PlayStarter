package skeletons.response;

import lombok.Getter;
import lombok.Setter;

import javax.inject.Singleton;

@Setter
@Getter
public class FeedBackResponse {

    private Boolean isUpdated;

    private String updateMessage;
}

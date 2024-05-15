package mission.study.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Builder
@Getter
public class ErrorReasonDTO {
    private String code;
    private String message;
    private Boolean isSuccess;
    private HttpStatus httpStatus;

}

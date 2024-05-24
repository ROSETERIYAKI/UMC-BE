package mission.study.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mission.study.apiPayload.code.BaseErrorCode;
import mission.study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonStatus() {
        return this.code.getReasonHttpStatus();
    }
}

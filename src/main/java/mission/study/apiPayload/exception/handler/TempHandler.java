package mission.study.apiPayload.exception.handler;

import mission.study.apiPayload.code.BaseErrorCode;
import mission.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

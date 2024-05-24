package mission.study.apiPayload.exception.handler;

import mission.study.apiPayload.code.BaseErrorCode;
import mission.study.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

package mission.study.apiPayload.exception.handler;

import mission.study.apiPayload.code.BaseErrorCode;
import mission.study.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

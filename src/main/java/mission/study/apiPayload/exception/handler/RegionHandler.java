package mission.study.apiPayload.exception.handler;

import mission.study.apiPayload.code.BaseErrorCode;
import mission.study.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorCode) {super(errorCode);}
}

package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class StoreRegionHandler extends GeneralException {

    public StoreRegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

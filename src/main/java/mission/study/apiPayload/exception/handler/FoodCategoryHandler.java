package mission.study.apiPayload.exception.handler;

import mission.study.apiPayload.code.BaseErrorCode;
import mission.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {super(errorCode);}
}

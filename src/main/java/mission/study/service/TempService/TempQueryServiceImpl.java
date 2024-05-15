package mission.study.service.TempService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.code.status.ErrorStatus;
import mission.study.apiPayload.exception.handler.TempHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {
    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1) {
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}

package mission.study.service.StoreService;

import mission.study.domain.Store;
import mission.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store joinStore(StoreRequestDTO.JoinDTO request);
}

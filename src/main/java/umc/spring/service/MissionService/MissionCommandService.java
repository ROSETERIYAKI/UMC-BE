package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission createMission(MissionRequestDTO.MissionCreateDTO request, Long storeId);
    Page<Mission> getStoreMissionList(Store store,Integer page, Integer size);
}

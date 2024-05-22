package mission.study.service.MIssionService;

import mission.study.domain.Mission;
import mission.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Mission joinMission(MissionRequestDTO.JoinDTO request);
    public Mission changeReward(Long missionId);
}

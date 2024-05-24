package mission.study.service.MissionService;

import mission.study.domain.Mission;
import mission.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Mission joinMission(MissionRequestDTO.JoinMissionDTO request);
    public Mission challenge(Long missionId, Long memberId);
}

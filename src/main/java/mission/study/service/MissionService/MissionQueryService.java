package mission.study.service.MissionService;

import mission.study.domain.Mission;

public interface MissionQueryService {
    public Mission findById(Long missionId);
}

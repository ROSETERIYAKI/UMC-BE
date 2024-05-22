package mission.study.service.MIssionService;

import mission.study.domain.Mission;

public interface MissionQueryService {
    public Mission findById(Long missionId);
}

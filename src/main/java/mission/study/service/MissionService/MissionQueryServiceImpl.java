package mission.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.code.status.ErrorStatus;
import mission.study.apiPayload.exception.handler.MissionHandler;
import mission.study.domain.Mission;
import mission.study.repository.MissionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    @Override
    public Mission findById(Long missionId) {
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        return mission;
    }
}

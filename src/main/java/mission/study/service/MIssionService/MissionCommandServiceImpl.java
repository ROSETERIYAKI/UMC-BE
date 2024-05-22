package mission.study.service.MIssionService;

import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.code.status.ErrorStatus;
import mission.study.apiPayload.exception.handler.MissionHandler;
import mission.study.apiPayload.exception.handler.StoreHandler;
import mission.study.converter.MissionConverter;
import mission.study.domain.Mission;
import mission.study.domain.Store;
import mission.study.domain.enums.Reward;
import mission.study.repository.MissionRepository;
import mission.study.repository.StoreRepository;
import mission.study.web.dto.MissionRequestDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    @Override
    public Mission joinMission(MissionRequestDTO.JoinDTO request) {
        Mission mission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(request.getStore()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        mission.setStore(store);
        return missionRepository.save(mission);
    }

    @Override
    public Mission changeReward(Long missionId) {
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        mission.setReward(Reward.IN_PROGRESS);
        return mission;
    }
}

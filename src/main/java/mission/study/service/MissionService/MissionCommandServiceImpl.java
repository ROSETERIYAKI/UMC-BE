package mission.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.code.status.ErrorStatus;
import mission.study.apiPayload.exception.handler.MemberHandler;
import mission.study.apiPayload.exception.handler.MissionHandler;
import mission.study.apiPayload.exception.handler.StoreHandler;
import mission.study.converter.MissionConverter;
import mission.study.domain.Member;
import mission.study.domain.Mission;
import mission.study.domain.Store;
import mission.study.domain.mapping.MemberMission;
import mission.study.repository.MemberRepository;
import mission.study.repository.MissionRepository;
import mission.study.repository.StoreRepository;
import mission.study.web.dto.MissionRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    @Override
    public Mission joinMission(MissionRequestDTO.JoinMissionDTO request) {
        Mission mission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(request.getStore()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        mission.setStore(store);
        return missionRepository.save(mission);
    }

    @Override
    public Mission challenge(Long missionId, Long memberId) {
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();

        return mission;
    }
}

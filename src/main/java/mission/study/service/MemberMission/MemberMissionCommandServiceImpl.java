package mission.study.service.MemberMission;

import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.code.status.ErrorStatus;
import mission.study.apiPayload.exception.handler.MemberHandler;
import mission.study.apiPayload.exception.handler.MissionHandler;
import mission.study.converter.MemberMissionConverter;
import mission.study.domain.Member;
import mission.study.domain.Mission;
import mission.study.domain.mapping.MemberMission;
import mission.study.repository.MemberMissionRepository;
import mission.study.repository.MemberRepository;
import mission.study.repository.MissionRepository;
import mission.study.validation.annotation.AlreadyChallenging;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission joinMemberMission(Long missionId, Long memberId) {
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        MemberMission memberMission = MemberMissionConverter.toMemberMission(memberId, missionId);
        memberMission.setMember(member);
        memberMission.setMission(mission);
        return memberMissionRepository.save(memberMission);
    }
}

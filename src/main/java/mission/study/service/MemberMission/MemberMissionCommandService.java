package mission.study.service.MemberMission;

import mission.study.domain.mapping.MemberMission;

public interface MemberMissionCommandService {
    public MemberMission joinMemberMission(Long missionId, Long memberId);
}

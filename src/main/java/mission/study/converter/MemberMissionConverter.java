package mission.study.converter;

import mission.study.domain.Mission;
import mission.study.domain.mapping.MemberMission;
import mission.study.web.dto.MemberMissionResponseDTO;
import mission.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Long memberId, Long missionId) {
        return MemberMission.builder()
                .build();
    }
    public static MemberMissionResponseDTO.challengeResultDTO toChallengeResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.challengeResultDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}

package umc.spring.converter;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.MemberMissionResultDTO toMemberMissionResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.MemberMissionResultDTO.builder()
                .MemberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionCompletedResultDTO toMemberMissionCompletedResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.MemberMissionCompletedResultDTO.builder()
                .MemberMissionId(memberMission.getId())
                .updatedAt(memberMission.getUpdatedAt())
                .build();
    }
}

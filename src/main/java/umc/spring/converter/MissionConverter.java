package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionResponseDTO;

public class MissionConverter {
    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(Mission mission){
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}

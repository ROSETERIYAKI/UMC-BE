package mission.study.converter;

import mission.study.domain.Mission;
import mission.study.domain.enums.Reward;
import mission.study.web.dto.MissionRequestDTO;
import mission.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.JoinDTO request) {
        return Mission.builder()
                .deadLine(request.getDeadLine())
                .mission_spec(request.getMission_spec())
                .build();
    }

    public static MissionResponseDTO.ChangeRewardResultDTO toChangeRewardResultDTO(Mission mission) {
        return MissionResponseDTO.ChangeRewardResultDTO.builder()
                .missionId(mission.getId())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}

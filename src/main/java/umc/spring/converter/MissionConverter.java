package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;

public class MissionConverter {
    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(Mission mission){
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static StoreResponseDTO.StoreMissionListDTO toStoreMissionListDTO(Page<Mission> missionList){
        List<StoreResponseDTO.StoreMissionDTO> storeMissionDTOList = missionList.stream()
                .map(MissionConverter::toStoreMissionDTO)
                .toList();

        return StoreResponseDTO.StoreMissionListDTO.builder()
                .listSize(missionList.getSize())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .missions(storeMissionDTOList)
                .build();
    }

    public static StoreResponseDTO.StoreMissionDTO toStoreMissionDTO(Mission mission){
        return StoreResponseDTO.StoreMissionDTO.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getMissionSpec())
                .build();
    }
}

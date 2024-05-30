package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.MemberMissionResultDTO toMemberMissionResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.MemberMissionResultDTO.builder()
                .MemberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

    public static MemberMissionResponseDTO.OngoingMissionDTO ongoingMissionDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.OngoingMissionDTO.builder()
                .member(memberMission.getMember())
                .mission(memberMission.getMission())
                .state(memberMission.getStatus())
                .build();
    }

    public static MemberMissionResponseDTO.OngoingMissionListDTO ongoingMissionListDTO(Page<MemberMission> memberMissionList) {
        List<MemberMissionResponseDTO.OngoingMissionDTO> ongoingMissionDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::ongoingMissionDTO).collect(Collectors.toList());
        return MemberMissionResponseDTO.OngoingMissionListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(ongoingMissionDTOList.size())
                .OngoingMissionList(ongoingMissionDTOList)
                .build();
    }
}

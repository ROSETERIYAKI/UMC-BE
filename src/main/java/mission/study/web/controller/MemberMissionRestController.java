package mission.study.web.controller;

import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.ApiResponse;
import mission.study.converter.MemberMissionConverter;
import mission.study.domain.mapping.MemberMission;
import mission.study.service.MemberMission.MemberMissionCommandService;
import mission.study.validation.annotation.AlreadyChallenging;
import mission.study.web.dto.MemberMissionResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member_mission/")
@RequiredArgsConstructor
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;
    @PostMapping("/{memberId}/{missionId}")
    public  ApiResponse<MemberMissionResponseDTO.challengeResultDTO> changeReward
            (@AlreadyChallenging @PathVariable("missionId") Long missionId, @PathVariable("memberId") Long memberId)
    {
        MemberMission memberMission = memberMissionCommandService.joinMemberMission(missionId, memberId);
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengeResultDTO(memberMission));
    }
}

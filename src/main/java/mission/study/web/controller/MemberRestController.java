package mission.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.ApiResponse;
import mission.study.converter.MemberConverter;
import mission.study.domain.Member;
import mission.study.service.MemberService.MemberCommandService;
import mission.study.web.dto.MemberRequestDTO;
import mission.study.web.dto.MemberResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinMemberDTO request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}

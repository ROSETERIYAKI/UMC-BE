package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    private final MemberQueryService memberQueryService;

    // 미션 생성 API
    @PostMapping("/stores/{storeId}")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> createMission(@RequestBody MissionRequestDTO.MissionCreateDTO request, @PathVariable(name = "storeId")Long storeId){
        Mission mission = missionCommandService.createMission(request, storeId);

        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    }

    @GetMapping("/ongoing/{memberId}")
    @Operation(summary = "특정 유저가 진행 중인 미션 목록 조회 API", description = "특정 유저가 현재 진행중인 미션의 목록을 보여주는 API이며, 페이징 포함 / query String으로 page 번호 부여 필요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "유효하지 않은 페이지 번호(1 미만)", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "조회하고 싶은 사용자 아이디, path variable")
    })
    public ApiResponse<MemberMissionResponseDTO.OngoingMissionListDTO> getOngoingMissionList(@PathVariable(name = "memberId") Long memberId,@Valid @CheckPage @RequestParam(name = "page") Integer page) {
        memberQueryService.getOngoinMissionList(memberId, page - 1);
        return null;
    }
}


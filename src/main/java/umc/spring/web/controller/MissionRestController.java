package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/stores/{storeId}")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> createMission(@RequestBody MissionRequestDTO.MissionCreateDTO request, @PathVariable(name = "storeId")Long storeId){
        Mission mission = missionCommandService.createMission(request, storeId);

        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));

    }
}

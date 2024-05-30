package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final MissionCommandService missionCommandService;

    // Store 생성
    @PostMapping("/regions/{regionId}")
    public ApiResponse<StoreResponseDTO.StoreResultDTO> createStore(@RequestBody StoreRequestDTO.StoreInfoDto request, @PathVariable(name = "regionId") Long regionId){
        Store store = storeCommandService.createStore(request, regionId);

        return ApiResponse.onSuccess(StoreConverter.toStoreResultDTO(store));
    }

    @GetMapping("/{storeId}/missions")
    public ApiResponse<StoreResponseDTO.StoreMissionListDTO> getStoreMissionList(@PathVariable(name = "storeId")Long storeId, @RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer size){
        Store store = storeCommandService.findById(storeId);

        Page<Mission> missionList = missionCommandService.getStoreMissionList(store, page, size);

        return ApiResponse.onSuccess(MissionConverter.toStoreMissionListDTO(missionList));
    }
}

package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/regions/{regionId}")
    public ApiResponse<StoreResponseDTO.StoreResultDTO> createStore(@RequestBody StoreRequestDTO.StoreInfoDto request, @PathVariable(name = "regionId") Long regionId){
        Store store = storeCommandService.createStore(request, regionId);

        return ApiResponse.onSuccess(StoreConverter.toStoreResultDTO(store));
    }
}

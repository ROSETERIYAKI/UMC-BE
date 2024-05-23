package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.service.StoreService.StoreCommandServiceImpl;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/new")
    public ApiResponse<StoreResponseDTO.addDTO> add(@RequestBody @Valid StoreRequestDTO.addDTO request) {
        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddStoreResultDTO(store));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.addReviewResultDTO> addReview(@RequestBody @Valid StoreRequestDTO.addReviewDTO request,
                                                                      @PathVariable(name="storeId") Long storeId,
                                                                      @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.addReview(request, storeId, memberId);
        return ApiResponse.onSuccess(StoreConverter.toAddReviewDTO(review));
    }
}

package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/stores/{storeId}")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> createReview(@RequestBody ReviewRequestDTO.ReviewInfoDTO request,@ExistStore @PathVariable(name = "storeId")Long storeId){
        Review review = reviewCommandService.createReview(request, storeId);

        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }
}

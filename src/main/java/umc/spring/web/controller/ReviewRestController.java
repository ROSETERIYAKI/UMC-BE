package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.ReviewResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @GetMapping("")
    @Operation(summary = "유저의 리뷰 리스트 가져오기", description = "유저가 작성한 모든 리뷰를 가져옵니다.")
    public ApiResponse<List<ReviewResponseDTO.GetReviewDetail>> getMyReviewList(@RequestParam Long id, @CheckPage @RequestParam Integer page) {
        return ApiResponse.onSuccess(reviewCommandService.getMyReviewList(id, page));
    }

}

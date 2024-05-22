package mission.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.ApiResponse;
import mission.study.converter.ReviewConverter;
import mission.study.domain.Review;
import mission.study.service.ReviewService.ReviewCommandService;
import mission.study.web.dto.ReviewRequestDTO;
import mission.study.web.dto.ReviewResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.JoinDTO request) {
        Review review = reviewCommandService.joinReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinDTO(review));
    }
}
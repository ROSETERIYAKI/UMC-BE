package mission.study.converter;

import mission.study.domain.Review;
import mission.study.web.dto.ReviewRequestDTO;
import mission.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    // review -> 응답값을 위한 ResponseDTO 로 변환
    public static ReviewResponseDTO.JoinResultDTO toJoinDTO(Review review) {
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.JoinReviewDTO request) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}

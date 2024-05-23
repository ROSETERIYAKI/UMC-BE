package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewJoinResultDTO ReviewJoinResultDTO(Review review) {
        return ReviewResponseDTO.ReviewJoinResultDTO.builder()
                .ReviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review createReview(ReviewRequestDTO.ReviewJoinDTO request) {
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .store(null)
                .member(null)
                .build();
    }
}

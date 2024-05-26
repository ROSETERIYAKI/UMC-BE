package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .ReviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}

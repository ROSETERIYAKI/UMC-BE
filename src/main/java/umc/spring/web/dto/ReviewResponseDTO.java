package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Review;

import java.time.LocalDateTime;

public class ReviewResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewResultDTO{
        private Long ReviewId;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetReviewDetail {
        @NotNull
        private String name;
        @Positive
        private Float score;
        @NotNull
        private String content;
        @NotNull
        private String title;
        @NotNull
        private LocalDateTime createdAt;

        public static GetReviewDetail fromReview(Review review) {
            return GetReviewDetail.builder()
                    .name(review.getMember().getName())
                    .score(review.getScore())
                    .content(review.getContent())
                    .title(review.getTitle())
                    .createdAt(review.getCreatedAt())
                    .build();
        }
    }
}

package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewInfoDTO{
        @Positive
        private Long member;
        @Positive
        private Long store;
        @NotNull
        private String content;
        @Positive
        private Float score;
        @NotNull
        private String title;
    }
}

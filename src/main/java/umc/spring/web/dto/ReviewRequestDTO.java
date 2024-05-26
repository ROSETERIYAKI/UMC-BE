package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewInfoDTO{
        @NotNull
        private String content;

        private Float score;
    }
}

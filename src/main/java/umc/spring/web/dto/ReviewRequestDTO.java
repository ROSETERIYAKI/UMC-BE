package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewJoinDTO{
        @NotNull
        private String content;

        private Float score;

        @Setter
        Long storeId;

        @NotNull
        Long memberId;
    }
}

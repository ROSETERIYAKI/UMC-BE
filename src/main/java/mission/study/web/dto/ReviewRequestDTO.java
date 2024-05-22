package mission.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class JoinDTO {
        @NotNull
        String body;
        Float score;
        @NotNull
        Long member;
        @NotNull
        Long store;
    }
}

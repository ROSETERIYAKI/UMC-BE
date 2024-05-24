package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDto {
        @NotNull
        private Integer reward;
        @NotNull
        private String missionSpec;
    }

    @Getter
    public static class ChallengeMissionDto {
        @NotNull
        private Long memberId;
    }
}
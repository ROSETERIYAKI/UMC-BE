package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDto {
        @NotNull
        Integer reward;
        @NotNull
        String missionSpec;
    }
}
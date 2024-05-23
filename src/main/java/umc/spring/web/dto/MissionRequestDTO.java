package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class MissionCreateDTO{
        @NotNull
        private Integer reward;
        @NotNull
        private LocalDate deadline;
        @NotNull
        private String missionSpec;
    }
}

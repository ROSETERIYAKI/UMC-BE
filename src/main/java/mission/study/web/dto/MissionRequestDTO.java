package mission.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class MissionRequestDTO {
    @Getter
    public static class JoinDTO {
        LocalDate deadLine;
        String mission_spec;
        @NotNull
        Long store;
    }
}

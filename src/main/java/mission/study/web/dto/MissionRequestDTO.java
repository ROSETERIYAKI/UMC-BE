package mission.study.web.dto;

import lombok.Getter;
import mission.study.validation.annotation.ExistStores;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class JoinMissionDTO {
        Integer reward;
        LocalDate deadLine;
        String mission_spec;
        @ExistStores
        Long store;
    }
}

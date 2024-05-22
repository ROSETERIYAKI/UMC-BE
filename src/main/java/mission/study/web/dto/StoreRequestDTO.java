package mission.study.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class JoinDTO {
        @NotNull
        String name;
        @Size(min = 5, max = 12)
        String address;
        Float score;
        @NotNull
        Long region;
    }
}

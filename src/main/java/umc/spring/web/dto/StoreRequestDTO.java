package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class StoreInfoDto{
        @NotNull
        private String name;
        @NotNull
        private String address;
    }
}

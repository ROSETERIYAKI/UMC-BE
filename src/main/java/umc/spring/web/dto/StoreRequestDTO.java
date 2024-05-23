package umc.spring.web.dto;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class addDTO {
        @NotBlank
        String name;
        @NotNull
        @Size(max = 40)
        String address;
        @NotNull
        Long region;
    }

    @Getter
    public static class addReviewDTO {
        @NotBlank
        String title;
        @NotBlank
        String content;
        @NotNull
        Float Score;
    }

    @Getter
    public static class addMissionDTO {
        @NotNull
        Integer reward;
        @NotNull
        @NotBlank
        String missionSpec;
        @NotNull
        LocalDate deadline;
    }
}


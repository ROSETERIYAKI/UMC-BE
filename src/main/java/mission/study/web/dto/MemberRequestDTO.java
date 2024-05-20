package mission.study.web.dto;

import lombok.Getter;
import mission.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto {
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        @ExistCategories
        List<Long> preferCategory;
    }
}

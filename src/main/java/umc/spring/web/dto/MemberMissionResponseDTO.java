package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionResultDTO{
        public Long MemberMissionId;
        public LocalDateTime createdAt;
    }

    // 미션 완료 요청에 대한 반환 DTO
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionCompletedResultDTO{
        public Long MemberMissionId;
        public LocalDateTime updatedAt;
    }
}

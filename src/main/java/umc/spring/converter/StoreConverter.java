package umc.spring.converter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.addDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.addDTO.builder()
                .storeId(store.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.addDTO request) {
        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .region(null)
                .build();
    }

    public static StoreResponseDTO.addReviewResultDTO toAddReviewDTO(Review review) {
        return StoreResponseDTO.addReviewResultDTO.builder()
                .reviewId(review.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(StoreRequestDTO.addReviewDTO request) {
        return Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .score(request.getScore())
                .build();
    }

    public static StoreResponseDTO.addMissionResultDTO toAddMissionDTO(Mission mission) {
        return StoreResponseDTO.addMissionResultDTO.builder()
                .missionId(mission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(StoreRequestDTO.addMissionDTO request) {
        return Mission.builder()
                .reward(request.getReward())
                .missionSpec(request.getMissionSpec())
                .deadline(request.getDeadline())
                .build();
    }
}

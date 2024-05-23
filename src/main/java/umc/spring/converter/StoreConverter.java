package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

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
}

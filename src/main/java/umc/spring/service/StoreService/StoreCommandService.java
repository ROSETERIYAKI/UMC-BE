package umc.spring.service.StoreService;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store addStore(StoreRequestDTO.addDTO request);

    Review addReview(StoreRequestDTO.addReviewDTO request, Long storeId, Long memberId);
}

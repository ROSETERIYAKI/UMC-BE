package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.util.List;

public interface ReviewCommandService {
    Review createReview(ReviewRequestDTO.ReviewInfoDTO request, Long storeId);
    // 유저의 리뷰 리스트를 가져오는 메서드
    List<ReviewResponseDTO.GetReviewDetail> getMyReviewList(Long memberId, Integer page);
}

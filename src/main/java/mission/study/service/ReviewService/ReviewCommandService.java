package mission.study.service.ReviewService;

import mission.study.domain.Review;
import mission.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review joinReview(ReviewRequestDTO.JoinDTO request);
}

package mission.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.code.status.ErrorStatus;
import mission.study.apiPayload.exception.handler.FoodCategoryHandler;
import mission.study.apiPayload.exception.handler.MemberHandler;
import mission.study.apiPayload.exception.handler.StoreHandler;
import mission.study.converter.ReviewConverter;
import mission.study.domain.Member;
import mission.study.domain.Review;
import mission.study.domain.Store;
import mission.study.repository.MemberRepository;
import mission.study.repository.ReviewRepository;
import mission.study.repository.StoreRepository;
import mission.study.web.dto.ReviewRequestDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review joinReview(ReviewRequestDTO.JoinReviewDTO request) {
        Review review = ReviewConverter.toReview(request);
        Member member = memberRepository.findById(request.getMember()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStore()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        review.setMember(member);
        review.setStore(store);
        return reviewRepository.save(review);
    }
}

package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public Review createReview(ReviewRequestDTO.ReviewInfoDTO request, Long storeId) {
        Store store = storeRepository.getReferenceById(storeId);

        Review review = Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .store(store)
                .member(memberRepository.getReferenceById(1L))
                .title(request.getTitle())
                .build();

        return reviewRepository.save(review);
    }

    @Override
    public List<ReviewResponseDTO.GetReviewDetail> getMyReviewList(Long memberId, Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 10); // 페이지 크기를 10으로 설정
        List<Review> reviews = reviewRepository.findByMemberId(memberId, pageRequest).getContent();
        return reviews.stream()
                .map(ReviewResponseDTO.GetReviewDetail::fromReview)
                .collect(Collectors.toList());
    }
}

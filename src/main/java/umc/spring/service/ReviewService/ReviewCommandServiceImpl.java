package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;

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
                .build();

        return reviewRepository.save(review);
    }
}

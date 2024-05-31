package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final ReviewCommandService reviewCommandService;


    // 회원가입 API
    @PostMapping
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    // mission 도전 API
    @PostMapping("/missions/{missionId}")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionResultDTO> challengeMission(@PathVariable(name = "missionId")Long missionId){
        MemberMission memberMission = memberCommandService.challengeMission(missionId);

        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDTO(memberMission));
    }

    // mission 완료 API
    @PostMapping("/missions_completed/{memberMissionId}")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionCompletedResultDTO> completedMission(@PathVariable(name = "memberMissionId")Long memberMissionId){
        MemberMission memberMission = memberCommandService.completedMission(memberMissionId);

        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionCompletedResultDTO(memberMission));
    }

    // 리뷰 작성 API
    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> createReview(@RequestBody ReviewRequestDTO.ReviewInfoDTO request, @ExistStore @PathVariable(name = "storeId")Long storeId){
        Review review = reviewCommandService.createReview(request, storeId);

        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }

}

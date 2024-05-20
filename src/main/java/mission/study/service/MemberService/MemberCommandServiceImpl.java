package mission.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.code.status.ErrorStatus;
import mission.study.apiPayload.exception.handler.FoodCategoryHandler;
import mission.study.converter.MemberConverter;
import mission.study.converter.MemberPreferConverter;
import mission.study.domain.FoodCategory;
import mission.study.domain.Member;
import mission.study.domain.mapping.MemberPrefer;
import mission.study.repository.FoodCategoryRepository;
import mission.study.repository.MemberRepository;
import mission.study.web.dto.MemberRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                })
                .collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}

package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.BaseCode;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.apiPayload.exception.handler.MemberMissionHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    private final FoodCategoryRepository foodCategoryRepository;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    public MemberMission challengeMission(Long missionId) {
        Member member = memberRepository.getReferenceById(1L);
        Mission mission = missionRepository.findById(missionId).orElseThrow(()-> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        if(memberMissionRepository.existsByMemberAndMission(member, mission)){
            throw new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_EXIST);
        }
        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();

        return memberMissionRepository.save(memberMission);
    }

    @Override
    @Transactional
    public MemberMission completedMission(Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId).orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));
        memberMission.setStatus(MissionStatus.COMPLETE);
        return memberMission;
    }
}

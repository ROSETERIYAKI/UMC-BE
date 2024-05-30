package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;


    @Override
    public Page<MemberMission> getOngoinMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get(); // 조회하고 싶은 멤버 찾기
        // 조회하고 싶은 멤버의 미션 중 CHALLENGING 상태인 것 찾기
        Page<MemberMission> MemberMissionPage = memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
        return MemberMissionPage;
    }
}

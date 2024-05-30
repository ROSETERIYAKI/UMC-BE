package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;

public interface MemberQueryService {
    Page<MemberMission> getOngoinMissionList(Long memberId, Integer page);
}

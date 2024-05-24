package mission.study.service.MemberService;

import mission.study.domain.Member;
import mission.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinMemberDTO request);
}

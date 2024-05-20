package mission.study.converter;

import mission.study.domain.Member;
import mission.study.domain.enums.Gender;
import mission.study.web.dto.MemberRequestDTO;
import mission.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    // entity -> 리턴 시 필요한 값들만 DTO 로 감싸서 보내기
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // DTO -> entity
    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = null;
        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NULL;
                break;
        }
        return Member.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .birthYear(request.getBirthYear())
                .birthMonth(request.getBirthMonth())
                .birthMonth(request.getBirthDay())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}

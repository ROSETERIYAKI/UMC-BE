package mission.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.code.status.ErrorStatus;
import mission.study.domain.mapping.MemberMission;
import mission.study.repository.MemberMissionRepositoryCustom;
import mission.study.validation.annotation.AlreadyChallenging;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AlreadyChallengingValidator  implements ConstraintValidator<AlreadyChallenging, Long> {
    private final MemberMissionRepositoryCustom memberMissionRepositoryCustom;

    @Override
    public void initialize(AlreadyChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Boolean isValid = memberMissionRepositoryCustom.findByMemberMissionId(value, value);

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_PROGRESS.toString()).addConstraintViolation();
            return false;
        }

        return true;
    }
}

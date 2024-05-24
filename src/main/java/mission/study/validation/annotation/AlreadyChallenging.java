package mission.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import mission.study.validation.validator.AlreadyChallengingValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AlreadyChallengingValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AlreadyChallenging {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

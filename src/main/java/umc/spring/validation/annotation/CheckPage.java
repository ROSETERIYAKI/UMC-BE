package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.CheckPageValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckPageValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD,ElementType.PARAMETER})
public @interface CheckPage {
    String message() default "해당하는 범위가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

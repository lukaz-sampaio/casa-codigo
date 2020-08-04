package deveficiente.codehouse.lab.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author lucas
 */
@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

    String message() default "must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String property();

    Class<?> domain();
}

package zust.online.crp.validator;

import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import lombok.extern.slf4j.Slf4j;
import zust.online.crp.annotation.SensitiveWords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author qcqcqc
 */
@Slf4j
public class SensitiveWordsValidator implements ConstraintValidator<SensitiveWords, CharSequence> {

    @Override
    public void initialize(SensitiveWords constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        boolean contains = SensitiveWordHelper.contains(value.toString());
        if (contains) {
            context.disableDefaultConstraintViolation();
            String first = SensitiveWordHelper.findFirst(value.toString());
            log.info("检测到违禁词: {}", first);
            context.buildConstraintViolationWithTemplate("违禁词: " + first)
                    .addConstraintViolation();
        }
        return !contains;
    }
}

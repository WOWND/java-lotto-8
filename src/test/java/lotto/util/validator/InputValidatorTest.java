package lotto.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("InputValidator 테스트")
public class InputValidatorTest {
    @Test
    void 빈_문자열_입력() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateNotEmpty(null));

        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateNotEmpty(""));
    }

    @Test
    void 공백만_입력() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateNotEmpty("  "));
    }


    @Test
    void 숫자형식이_아닌_입력_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateIsNumber("1000j"));
    }

    @Test
    void 실수형_입력() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateIsNumber("1000.00"));
    }
}

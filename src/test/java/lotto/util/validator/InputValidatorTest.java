package lotto.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("InputValidator 테스트")
class InputValidatorTest {
    
    @Test
    void 정상_입력() {
        assertDoesNotThrow(() -> InputValidator.validateNotEmpty("1000"));
    }

    @Test
    void null_입력_예외() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열_입력_예외() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백만_입력_예외() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

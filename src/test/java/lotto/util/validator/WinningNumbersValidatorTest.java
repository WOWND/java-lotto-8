package lotto.util.validator;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningNumbersValidatorTest 테스트")
class WinningNumbersValidatorTest {
    @Test
    void 당첨번호_개수_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validate(List.of(1, 2, 3, 4, 5, 6, 7)));
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validate(List.of(1, 2, 3)));
    }

    @Test
    void 당첨번호_중복_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validate(List.of(1, 2, 3, 3, 4, 4)));
    }

    @Test
    void 당첨번호_범위_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validate(List.of(-1, 2, 3, 4, 5, 6)));
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validate(List.of(1, 2, 3, 4, 5, 46)));
    }
}
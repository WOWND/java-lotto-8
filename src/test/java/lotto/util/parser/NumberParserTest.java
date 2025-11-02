package lotto.util.parser;

import lotto.util.validator.InputValidator;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("NumberParserTest 테스트")
public class NumberParserTest {
    @Test
    void 숫자형식이_아닌_입력_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberParser.parse("1000j"));
    }

    @Test
    void 실수형_입력() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberParser.parse("1000.00"));
    }
}

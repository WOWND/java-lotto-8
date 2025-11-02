package lotto.util.parser;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningNumberParserTest 테스트")
class WinningNumberParserTest {
    @Test
    void 문자_포함_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumberParser.parse(List.of("1", "2", "3", "4j", "5", "6")));
    }
}
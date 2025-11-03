package lotto.util.parser;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("WinningNumberParser 테스트")
class WinningNumberParserTest {
    
    @Test
    void 정상_당첨번호_분할() {
        List<String> result = WinningNumberParser.split("1,2,3,4,5,6");
        assertThat(result).hasSize(6);
        assertThat(result).contains("1", "2", "3", "4", "5", "6");
    }

    @Test
    void 공백_포함_분할() {
        List<String> result = WinningNumberParser.split("1, 2, 3, 4, 5, 6");
        assertThat(result).hasSize(6);
    }

    @Test
    void 정상_당첨번호_파싱() {
        List<Integer> result = WinningNumberParser.parse(List.of("1", "9", "15", "30", "43", "45"));
        assertThat(result).contains(1, 9, 15, 30, 43, 45);
    }

    @Test
    void 숫자_외_문자_파싱_예외() {
        assertThatThrownBy(() -> WinningNumberParser.parse(List.of("1", "abc", "3", "4", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정렬되지_않은_번호_정렬() {
        List<Integer> result = WinningNumberParser.parse(List.of("45", "1", "30", "9", "43", "15"));
        assertThat(result).contains(1, 9, 15, 30, 43, 45);
    }
}

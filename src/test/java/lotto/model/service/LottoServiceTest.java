package lotto.model.service;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoServiceTest 테스트")
class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 정상_금액_입력() {
        assertThat(lottoService.savePurchaseAmount("3000")).isEqualTo(3000);
    }

    @Test
    void 음수_입력_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> lottoService.savePurchaseAmount("-1000"));
    }

    @Test
    void 정상_당첨번호_입력() {
        List<Integer> winningNumbers = lottoService.saveWinningNumbers("1,9,15,30,43,45");
        assertThat(winningNumbers).contains(1, 9, 15, 30, 43, 45);
    }

    @Test
    void 정상_보너스번호_입력() {
        lottoService.saveWinningNumbers("1,2,3,4,5,6");
        int bonusNumber = lottoService.saveBonusNumber("7");
        assertThat(bonusNumber).isEqualTo(7);
    }
}

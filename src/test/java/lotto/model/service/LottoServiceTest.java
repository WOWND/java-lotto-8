package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
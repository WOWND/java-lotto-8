package lotto.model.service;

import lotto.model.domain.Lotto;
import lotto.model.dto.LottoResultDto;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("LottoService 테스트")
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

    @Test
    void 구매한_로또_개수_확인() {
        lottoService.savePurchaseAmount("8000");
        List<Lotto> lottos = lottoService.createLottos();
        assertThat(lottos).hasSize(8);
    }

    @Test
    void 정상_수익률_계산() {
        lottoService.savePurchaseAmount("8000");
        List<LottoResultDto> mockResults = List.of(
                new LottoResultDto(lotto.model.domain.LottoRank.FIFTH, 1)
        );
        double profitRate = lottoService.getProfitRate(mockResults);
        assertThat(profitRate).isEqualTo(62.5);
    }

    @Test
    void 빈_문자열_입력_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> lottoService.savePurchaseAmount(""));
    }

    @Test
    void 당첨번호_6개_미만_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> lottoService.saveWinningNumbers("1,2,3,4,5"));
    }

    @Test
    void 당첨번호_중복_예외() {
        assertThrows(IllegalArgumentException.class,
                () -> lottoService.saveWinningNumbers("1,1,2,3,4,5"));
    }

    @Test
    void 보너스번호_당첨번호_중복_예외() {
        lottoService.saveWinningNumbers("1,2,3,4,5,6");
        assertThrows(IllegalArgumentException.class,
                () -> lottoService.saveBonusNumber("6"));
    }

    @Test
    void 보너스번호_입력_전_당첨번호_미입력_예외() {
        assertThatThrownBy(() -> lottoService.saveBonusNumber("7"))
                .isInstanceOf(IllegalStateException.class);
    }
}

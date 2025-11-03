package lotto.model.dto;

import lotto.model.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoResultDto 테스트")
class LottoResultDtoTest {
    
    @Test
    void 당첨_결과_생성() {
        LottoResultDto dto = new LottoResultDto(LottoRank.FIRST, 1);
        assertThat(dto).isNotNull();
    }

    @Test
    void 총_상금_계산() {
        LottoResultDto dto = new LottoResultDto(LottoRank.FIFTH, 2);
        assertThat(dto.calculateTotalPrize()).isEqualTo(10_000); //5000 * 2
    }

    @Test
    void 여러_등급의_총_상금_계산() {
        LottoResultDto dto1 = new LottoResultDto(LottoRank.FIFTH, 1);
        LottoResultDto dto2 = new LottoResultDto(LottoRank.FOURTH, 1);
        long total = dto1.calculateTotalPrize() + dto2.calculateTotalPrize();
        assertThat(total).isEqualTo(55_000); //5000 + 55000
    }

    @Test
    void toString_형식() {
        LottoResultDto dto = new LottoResultDto(LottoRank.FIFTH, 3);
        String result = dto.toString();
        assertThat(result).contains("3개 일치 (5,000원) - 3개");
    }
}

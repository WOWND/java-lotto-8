package lotto.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto 테스트")
class LottoTest {
    
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_로또_번호_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString()).contains("1", "2", "3", "4", "5", "6");
    }


    @Test
    void 모두_일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoRank rank = lotto.getRank(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("2등_테스트")
    void 보너스_일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoRank rank = lotto.getRank(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("3등_테스트")
    void test3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        LottoRank rank = lotto.getRank(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("4등_테스트")
    void _4개_일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        LottoRank rank = lotto.getRank(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 낙첨() {
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        LottoRank rank = lotto.getRank(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(rank).isEqualTo(LottoRank.NONE);
    }

    @Test
    void 보너스번호만_일치() {
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        LottoRank rank = lotto.getRank(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(rank).isEqualTo(LottoRank.NONE);
    }
}

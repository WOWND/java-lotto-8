package lotto.model.dto;

import lotto.model.domain.LottoRank;

public class LottoResultDto {
    private final LottoRank rank;
    private final int matchCount;

    public LottoResultDto(LottoRank rank, int matchCount) {
        this.rank = rank;
        this.matchCount = matchCount;
    }

    @Override
    public String toString() {
        return String.format("%s - %d개", rank, matchCount);
    }

    public long calculateTotalPrize() {
        return rank.getPrize() * matchCount;
    }
}

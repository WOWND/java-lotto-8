package lotto.model.domain;

public enum LottoRank {
    FIRST(5, "6개 일치", 2_000_000_000),
    SECOND(4,"5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD(3,"5개 일치", 1_500_000),
    FOURTH(2,"4개 일치", 50_000),
    FIFTH(1,"3개 일치", 5_000),
    NONE(0,"낙첨", 0);

    private final int displayOrder;
    private final String message;
    private final int prize;

    LottoRank(int displayOrder, String message, int prize) {
        this.displayOrder = displayOrder;
        this.message = message;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && hasBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return String.format("%s (%,d)", message, prize);
    }
}

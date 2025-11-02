package lotto.util.validator;

public class PurchaseAmountValidator {
    private static final int UNIT = 1000;
    private static final int MIN_AMOUNT = 1000;

    private PurchaseAmountValidator() {
    }

    public static void validateUnit(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 구입 가능합니다");
        }
    }

    public static void validateMinAmount(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 최소 1,000원 이상이어야 합니다");
        }
    }
}

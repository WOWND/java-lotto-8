package lotto.util.validator;

import lotto.model.domain.LottoConstants;

public class PurchaseAmountValidator {
    private PurchaseAmountValidator() {
    }

    public static void validateUnit(int amount) {
        if (amount % LottoConstants.PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 구입 가능합니다");
        }
    }

    public static void validateMinAmount(int amount) {
        if (amount < LottoConstants.MIN_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 최소 1,000원 이상이어야 합니다");
        }
    }
}

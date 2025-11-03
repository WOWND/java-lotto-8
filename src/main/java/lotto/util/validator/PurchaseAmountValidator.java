package lotto.util.validator;

import lotto.exception.ErrorMessage;
import lotto.model.domain.LottoConstants;

public class PurchaseAmountValidator {
    private PurchaseAmountValidator() {
    }

    public static void validateUnit(int amount) {
        if (amount % LottoConstants.PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_UNIT.getMessage());
        }
    }

    public static void validateMinAmount(int amount) {
        if (amount < LottoConstants.MIN_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
    }
}

package lotto.model.service;

import lotto.util.parser.PurChaseAmountParser;
import lotto.util.validator.InputValidator;
import lotto.util.validator.PurchaseAmountValidator;

public class LottoService {
    private int purchaseAmount = 0;

    public int savePurchaseAmount(String input) {
        InputValidator.validateNotEmpty(input);
        InputValidator.validateIsNumber(input);

        int purchaseAmount = PurChaseAmountParser.parse(input);
        PurchaseAmountValidator.validateUnit(purchaseAmount);
        PurchaseAmountValidator.validateMinAmount(purchaseAmount);

        return this.purchaseAmount = purchaseAmount;
    }
}

package lotto.model.service;

import lotto.util.parser.PurChaseAmountParser;
import lotto.util.validator.InputValidator;
import lotto.util.validator.PurchaseAmountValidator;

public class LottoService {
    private int purchaseAmount = 0;

    public void savePurchaseAmount(String input) {
        InputValidator.validateNotEmpty(input);
        InputValidator.validateIsNumber(input);

        int purchaseAmount = PurChaseAmountParser.parse(input);
        PurchaseAmountValidator.validateUnit(purchaseAmount);
        PurchaseAmountValidator.validateMinAmount(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
    }
}

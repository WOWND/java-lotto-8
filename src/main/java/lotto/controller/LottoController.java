package lotto.controller;

import lotto.util.validator.InputValidator;
import lotto.util.parser.PurChaseAmountParser;
import lotto.util.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public LottoController() {

    }

    public void getPurchaseAmount() {
        OutputView.display();
        String input = InputView.readLine();
        InputValidator.validateNotEmpty(input);
        InputValidator.validateIsNumber(input);
        int purchaseAmount = PurChaseAmountParser.parse(input);
        PurchaseAmountValidator.validateUnit(purchaseAmount);
        PurchaseAmountValidator.validateMinAmount(purchaseAmount);
        System.out.println(purchaseAmount);
    }
}

package lotto.model.service;

import java.util.List;
import lotto.util.parser.PurChaseAmountParser;
import lotto.util.parser.WinningNumberParser;
import lotto.util.validator.InputValidator;
import lotto.util.validator.PurchaseAmountValidator;
import lotto.util.validator.WinningNumbersValidator;

public class LottoService {
    private int purchaseAmount = 0;
    private List<Integer> winningNumbers;

    public int savePurchaseAmount(String input) {
        InputValidator.validateNotEmpty(input);
        InputValidator.validateIsNumber(input);

        int purchaseAmount = PurChaseAmountParser.parse(input);
        PurchaseAmountValidator.validateUnit(purchaseAmount);
        PurchaseAmountValidator.validateMinAmount(purchaseAmount);

        return this.purchaseAmount = purchaseAmount;
    }

    public List<Integer> saveWinningNumbers(String input) {
        InputValidator.validateNotEmpty(input);

        List<String> parsed = WinningNumberParser.split(input);
        List<Integer> winningNumbers = WinningNumberParser.parse(parsed);
        WinningNumbersValidator.validate(winningNumbers);

        return this.winningNumbers = winningNumbers;
    }
}

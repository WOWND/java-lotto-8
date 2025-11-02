package lotto.model.service;

import java.util.List;
import lotto.util.parser.NumberParser;
import lotto.util.parser.WinningNumberParser;
import lotto.util.validator.InputValidator;
import lotto.util.validator.PurchaseAmountValidator;
import lotto.util.validator.LottoNumbersValidator;

public class LottoService {
    private int purchaseAmount = 0;
    private List<Integer> winningNumbers;
    private int bonusNumber = 0;

    public int savePurchaseAmount(String input) {
        InputValidator.validateNotEmpty(input);

        int purchaseAmount = NumberParser.parse(input);
        PurchaseAmountValidator.validateUnit(purchaseAmount);
        PurchaseAmountValidator.validateMinAmount(purchaseAmount);

        return this.purchaseAmount = purchaseAmount;
    }

    public List<Integer> saveWinningNumbers(String input) {
        InputValidator.validateNotEmpty(input);

        List<String> parsed = WinningNumberParser.split(input);
        List<Integer> winningNumbers = WinningNumberParser.parse(parsed);
        LottoNumbersValidator.validateWinningNumbers(winningNumbers);

        return this.winningNumbers = winningNumbers;
    }

    public int saveBonusNumber(String input) {
        InputValidator.validateNotEmpty(input);

        int bonusNumber = NumberParser.parse(input);
        LottoNumbersValidator.validateBonusNumbers(winningNumbers,bonusNumber);

        return this.bonusNumber = bonusNumber;
    }
}

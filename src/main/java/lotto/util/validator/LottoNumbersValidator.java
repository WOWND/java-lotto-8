package lotto.util.validator;

import java.util.HashSet;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.model.domain.LottoConstants;

public class LottoNumbersValidator {
    private LottoNumbersValidator() {
    }

    public static void validateWinningNumbers(List<Integer> numbers) {
        validateCount(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
    }

    public static void validateBonusNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers == null) {
            throw new IllegalStateException(ErrorMessage.WINNING_NUMBER_REQUIRED.getMessage());
        }
        validateNumberRange(bonusNumber);
        validateDuplicate(numbers,bonusNumber);
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < LottoConstants.MIN || number > LottoConstants.MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            }
            uniqueNumbers.add(number);
        }
    }

    private static void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }
}

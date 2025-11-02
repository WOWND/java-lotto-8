package lotto.util.validator;

import java.util.HashSet;
import java.util.List;
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
        validateNumberRange(numbers);
        validateDuplicate(numbers,bonusNumber);
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.COUNT) {
            throw new IllegalArgumentException("[ERROR] 6개의 당첨번호를 입력해야합니다");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstants.MIN || number > LottoConstants.MAX) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45입니다");
            }
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다");
            }
            uniqueNumbers.add(number);
        }
    }

    private static void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다");
        }
    }
}

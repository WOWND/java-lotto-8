package lotto.model.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다");
            }
            uniqueNumbers.add(number);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public LottoRank getRank(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = 0;
        boolean hasBonus = numbers.contains(bonusNumber);

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return LottoRank.valueOf(matchCount, hasBonus);
    }
}

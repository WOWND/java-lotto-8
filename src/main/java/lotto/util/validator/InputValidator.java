package lotto.util.validator;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다");
        }
    }
}

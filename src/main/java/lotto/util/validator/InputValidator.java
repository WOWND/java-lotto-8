package lotto.util.validator;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다");
        }
    }


    public static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다");
        }
    }
}

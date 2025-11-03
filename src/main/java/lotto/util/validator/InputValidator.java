package lotto.util.validator;

import lotto.exception.ErrorMessage;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }
}

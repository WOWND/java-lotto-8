package lotto.util.parser;

import lotto.exception.ErrorMessage;

public class NumberParser {
    private NumberParser() {
    }

    public static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }
}

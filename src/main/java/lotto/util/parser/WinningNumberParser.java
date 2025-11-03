package lotto.util.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorMessage;

public class WinningNumberParser {
    private static final String DELIMITER = ",";

    private WinningNumberParser() {
    }

    public static List<String> split(String input) {
        return Arrays.asList(input.split(DELIMITER, -1));
    }

    public static List<Integer> parse(List<String> numbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            try {
                result.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_INPUT.getMessage());
            }
        }
        return result;
    }
}

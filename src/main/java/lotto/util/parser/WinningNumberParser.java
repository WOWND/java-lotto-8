package lotto.util.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                throw new IllegalArgumentException("[Error] 당첨 번호는 숫자만 입력 가능합니다");
            }
        }
        return result;
    }
}

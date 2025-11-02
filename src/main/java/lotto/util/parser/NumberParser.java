package lotto.util.parser;

public class NumberParser {
    private NumberParser() {
    }

    public static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
        }
    }
}

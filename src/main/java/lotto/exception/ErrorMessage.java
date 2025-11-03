package lotto.exception;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어있습니다"),
    WINNING_NUMBER_REQUIRED("당첨번호를 입력한 뒤 보너스번호를 입력해야합니다"),
    INVALID_WINNING_NUMBER_COUNT("6개의 당첨번호를 입력해야합니다"),
    NUMBER_OUT_OF_RANGE("로또 번호의 범위는 1~45입니다"),
    DUPLICATE_NUMBER("중복된 번호는 입력할 수 없습니다"),
    BONUS_NUMBER_DUPLICATED("보너스 번호는 당첨 번호와 중복될 수 없습니다"),
    INVALID_PRICE_UNIT("1,000원 단위로만 구입 가능합니다"),
    MINIMUM_PURCHASE_AMOUNT("최소 1,000원 이상이어야 합니다"),
    INVALID_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_INPUT("숫자만 입력 가능합니다"),
    INVALID_WINNING_NUMBER_INPUT("숫자만 입력 가능합니다");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}

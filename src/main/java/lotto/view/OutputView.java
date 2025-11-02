package lotto.view;

public class OutputView {
    private OutputView() {
    }

    public static void display(String message) {
        System.out.println(message);
    }

    public static void purchaseAmount() {
        System.out.println(ViewMessages.PURCHASE_AMOUNT_MESSAGE);
    }

    public static void winningNumbers() {
        System.out.println(ViewMessages.WINNING_NUMBERS_MESSAGE);
    }

    public static void bonusNumber() {
        System.out.println(ViewMessages.BONUS_NUMBER_MESSAGE);
    }
}

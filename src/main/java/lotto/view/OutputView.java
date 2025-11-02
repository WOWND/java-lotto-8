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
}

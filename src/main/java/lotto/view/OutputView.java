package lotto.view;

import java.util.List;
import lotto.model.domain.Lotto;

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

    public static void displayLottos(List<Lotto> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }
}

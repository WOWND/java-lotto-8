package lotto.view;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.dto.LottoResultDto;

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

    public static void displayResults(List<LottoResultDto> lottoResults) {
        System.out.println(ViewMessages.LOTTO_RESULT_MESSAGE);
        for (LottoResultDto lottoResult : lottoResults) {
            System.out.println(lottoResult);
        }
    }

    public static void displayProfitRate(double profitRate) {
        System.out.printf((ViewMessages.PROFIT_RATE_MESSAGE) + "%n", profitRate);
    }
}

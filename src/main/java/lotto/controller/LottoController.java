package lotto.controller;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        processPurchaseAmount();
        processWinningNumbers();
        processBonusNumber();

        createLottos();
    }


    private void processPurchaseAmount() {
        while (true) {
            try {
                OutputView.purchaseAmount();
                String input = InputView.readLine();
                lottoService.savePurchaseAmount(input);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.display(e.getMessage());
            }
        }
    }

    private void processWinningNumbers() {
        while (true) {
            try {
                OutputView.winningNumbers();
                String input = InputView.readLine();
                lottoService.saveWinningNumbers(input);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.display(e.getMessage());
            }
        }
    }

    private void processBonusNumber() {
        while (true) {
            try {
                OutputView.bonusNumber();
                String input = InputView.readLine();
                lottoService.saveBonusNumber(input);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.display(e.getMessage());
            }
        }
    }

    private void createLottos() {
        List<Lotto> lottos = lottoService.createLottos();
        OutputView.displayLottos(lottos);
    }
}

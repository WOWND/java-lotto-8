package lotto;

import lotto.controller.LottoController;
import lotto.model.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new LottoService());
        lottoController.run();
    }
}

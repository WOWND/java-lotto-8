package lotto.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("PurchaseAmountValidator 테스트")
public class PurchaseAmountValidatorTest {


    @Test
    void 천원단위가_아닌_입력() {
        assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.validateUnit(2500));
        assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.validateUnit(1234));
        assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.validateUnit(10001));
    }

    @Test
    void 최소금액_미만_입력() {
        assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.validateMinAmount(0));
        assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.validateMinAmount(999));
        assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.validateMinAmount(-1000));
    }
}

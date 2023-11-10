package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EventTest {
    @DisplayName("별, 평일, 3일, 샴페인 증정 테스트")
    @Test
    void eventTest() {
        Menu menu = new Menu();
        menu.order(List.of(new Dish("아이스크림", 3), new Dish("티본스테이크", 3)));
        Event event = new Event(menu, 3);
        Assertions.assertThat(event.calcTotalDiscount())
            .isEqualTo(1000 + 2023 * 3 + 1200 + 25000);
    }
}

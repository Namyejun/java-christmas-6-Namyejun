package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MenuTest {
    @DisplayName("주문 안들어왔을 때 금액 출력")
    @Test
    void menuTestWithNoOrder() {
        Menu menu = new Menu();
        Assertions.assertThat(menu.getTotalPrice())
            .isEqualTo(0);
    }

    @DisplayName("주문 들어왔을 때 금액 출력")
    @Test
    void menuTestWithOrder() {
        Menu menu = new Menu();
        menu.order(List.of(new Dish("양송이수프", 3), new Dish("티본스테이크", 3)));
        Assertions.assertThat(menu.getTotalPrice())
            .isEqualTo(6000 * 3 + 55000 * 3);
    }
}

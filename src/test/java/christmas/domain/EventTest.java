package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EventTest {
    @DisplayName("별, 평일, 3일, 샴페인 증정 테스트")
    @Test
    void discountTest() {
        Menu menu = new Menu();
        menu.order(List.of(new Dish("아이스크림", 3), new Dish("티본스테이크", 3)));
        Event event = new Event(menu, 3);
        Assertions.assertThat(event.calcTotalDiscount())
            .isEqualTo(1000 + 2023 * 3 + 1200 + 25000);
    }

    @DisplayName("toString 할인 있을 때 테스트")
    @Test
    void toStringTestWithDiscount() {
        Menu menu = new Menu();
        menu.order(List.of(new Dish("아이스크림", 3), new Dish("티본스테이크", 3)));
        Event event = new Event(menu, 3);
        Assertions.assertThat(event.toString())
            .contains("크리스마스 디데이 할인: -1,200", "평일 할인: -6,069", "특별 할인: -1,000", "증정 이벤트: -25,000");
    }

    @DisplayName("toString 할인 없을 때 테스트")
    @Test
    void toStringTestWithNoDiscount() {
        Menu menu = new Menu();
        menu.order(List.of(new Dish("아이스크림", 1)));
        Event event = new Event(menu, 1);
        Assertions.assertThat(event.toString())
            .contains("없음");
    }
}

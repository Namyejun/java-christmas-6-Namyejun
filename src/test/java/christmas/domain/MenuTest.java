package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @DisplayName("수량을 입력하지 않았을 때")
    @Test
    void menuTestWithNoCount() {
        Menu menu = new Menu("양송이스프", MenuSection.에피타이저, 6000);
        Assertions.assertThat(menu.getTotalPrice())
            .isEqualTo(0);
    }

    @DisplayName("수량을 입력했을 때")
    @Test
    void menuTest() {
        Menu menu = new Menu("양송이스프", MenuSection.에피타이저, 6000);
        menu.setCount(3);
        Assertions.assertThat(menu.getTotalPrice())
            .isEqualTo(18000);
    }
}

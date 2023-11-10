package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DishTest {
    @DisplayName("수량을 입력하지 않았을 때")
    @Test
    void dishTestWithNoCount() {
        Dish dish = new Dish("양송이수프", DishSection.에피타이저, 6000);
        Assertions.assertThat(dish.getTotalPrice())
            .isEqualTo(0);
    }

    @DisplayName("수량을 입력했을 때")
    @Test
    void dishTestWithCount() {
        Dish dish = new Dish("양송이수프", DishSection.에피타이저, 6000);
        dish.setCount(3);
        Assertions.assertThat(dish.getTotalPrice())
            .isEqualTo(18000);
    }

    @DisplayName("이름 반환 테스트")
    @Test
    void dishNameTest() {
        Dish dish = new Dish("양송이수프", DishSection.에피타이저, 6000);
        Assertions.assertThat(dish.getName())
            .isEqualTo("양송이수프");
    }
}

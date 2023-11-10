package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DishSectionTest {
    @Test
    void menuSectionTest() {
        Assertions.assertThat(MenuSection.에피타이저.toString())
            .isEqualTo("에피타이저");

        Assertions.assertThat(MenuSection.메인.toString())
            .isEqualTo("메인");

        Assertions.assertThat(MenuSection.디저트.toString())
            .isEqualTo("디저트");

        Assertions.assertThat(MenuSection.음료.toString())
            .isEqualTo("음료");
    }
}

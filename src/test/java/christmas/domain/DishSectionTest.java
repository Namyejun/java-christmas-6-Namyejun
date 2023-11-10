package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DishSectionTest {
    @Test
    void menuSectionTest() {
        Assertions.assertThat(DishSection.에피타이저.toString())
            .isEqualTo("에피타이저");

        Assertions.assertThat(DishSection.메인.toString())
            .isEqualTo("메인");

        Assertions.assertThat(DishSection.디저트.toString())
            .isEqualTo("디저트");

        Assertions.assertThat(DishSection.음료.toString())
            .isEqualTo("음료");
    }
}

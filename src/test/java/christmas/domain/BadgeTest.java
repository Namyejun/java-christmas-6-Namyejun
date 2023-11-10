package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BadgeTest {
    @Test
    void badgeTest() {
        Assertions.assertThat(Badge.없음.toString())
            .isEqualTo("없음");

        Assertions.assertThat(Badge.별.toString())
            .isEqualTo("별");

        Assertions.assertThat(Badge.트리.toString())
            .isEqualTo("트리");

        Assertions.assertThat(Badge.산타.toString())
            .isEqualTo("산타");
    }
}

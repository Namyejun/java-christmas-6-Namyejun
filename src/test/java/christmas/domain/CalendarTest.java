package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalendarTest {
    @DisplayName("모든 평일을 포함하는지 테스트")
    @Test
    void weekdayTest() {
        Calendar calendar = new Calendar();
        Assertions.assertThat(calendar.getWeekday())
            .containsAll(List.of(3,4,5,6,7,10,11,12,13,14,17,18,19,20,21,24,25,26,27,28,31));
    }

    @DisplayName("모든 주말을 포함하는지 테스트")
    @Test
    void weekendTest() {
        Calendar calendar = new Calendar();
        Assertions.assertThat(calendar.getWeekend())
            .containsAll(List.of(1,2,8,9,15,16,22,23,29,30));
    }
}

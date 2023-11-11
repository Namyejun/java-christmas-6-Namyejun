package christmas.util;

import christmas.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    private Menu menu = new Menu();

    @DisplayName("예약 날짜 유효성 검사 예외 반환 테스트")
    @Test
    void validDateTestCheckException() {
        Validation validation = new Validation();

        Assertions.assertThatThrownBy(() -> validation.validateDate("153"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예약 날짜 유효성 검사")
    @Test
    void validDateTest() {
        Validation validation = new Validation();

        Assertions.assertThat(validation.validateDate("3"))
            .isEqualTo(3);
    }

    @DisplayName("중복 주문 검사")
    @Test
    void validDuplicateOrderTest() {
        Validation validation = new Validation();

        Assertions.assertThatThrownBy(() -> validation.tokenizeOrder("시저샐러드-1,시저샐러드-1", menu))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료 주문 검사")
    @Test
    void validBeverageOrderTest() {
        Validation validation = new Validation();

        Assertions.assertThatThrownBy(() -> validation.tokenizeOrder("제로콜라-2,레드와인-3", menu))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("20개 이상 주문 검사")
    @Test
    void validCountOrderTest() {
        Validation validation = new Validation();

        Assertions.assertThatThrownBy(() -> validation.tokenizeOrder("티본스테이크-15,제로콜라-3,레드와인-3", menu))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("없는 메뉴 주문 검사")
    @Test
    void validMenuOrderTest() {
        Validation validation = new Validation();

        Assertions.assertThatThrownBy(() -> validation.tokenizeOrder("뼈해장국-3,제로콜라-3,참이슬-2", menu))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1개 미만 주문 검사")
    @Test
    void validCountLessThanOneOrderTest() {
        Validation validation = new Validation();

        Assertions.assertThatThrownBy(() -> validation.tokenizeOrder("티본스테이크-0,제로콜라-3,레드와인-3", menu))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 형식 검사")
    @Test
    void validOrderFormTest() {
        Validation validation = new Validation();

        Assertions.assertThatThrownBy(() -> validation.tokenizeOrder("티본스테이크=1,제로콜라=3,레드와인=3", menu))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

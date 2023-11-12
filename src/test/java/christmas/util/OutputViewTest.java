package christmas.util;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.domain.Customer;
import christmas.domain.Dish;
import christmas.domain.Event;
import christmas.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OutputViewTest extends NsTest {

    @DisplayName("전체 테스트")
    @Test
    void outputViewTest() {
        run();
        Assertions.assertThat(output())
            .contains(
                "<주문 메뉴>" + System.lineSeparator(), "양송이수프 3개", "티본스테이크 3개",
                "<할인 전 총주문 금액>" + System.lineSeparator() + "183,000원",
                "<증정 메뉴>" + System.lineSeparator() + "샴페인 1개",
                "<혜택 내역>" + System.lineSeparator() +
                    "크리스마스 디데이 할인: -1,200원" + System.lineSeparator() +
                    "특별 할인: -1,000원" + System.lineSeparator() +
                    "증정 이벤트: -25,000원",
                "<총혜택 금액>" + System.lineSeparator() + "-27,200원",
                "<할인 후 예상 결제 금액>" + System.lineSeparator() + "155,800원",
                "<12월 이벤트 배지>" + System.lineSeparator() + "산타"
            );
    }

    @Override
    protected void runMain() {
        Menu menu = new Menu();
        menu.order(List.of(new Dish("양송이수프", 3), new Dish("티본스테이크", 3)));
        Customer customer = new Customer();
        Event event = new Event(menu, customer, 3);
        OutputView view = new OutputView(menu, event, customer);
        view.printMenu();
        view.beforeEvent();
        view.event();
        view.badge();
    }
}

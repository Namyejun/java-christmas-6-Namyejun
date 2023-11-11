package christmas.util;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;

public class InputViewTest extends NsTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @DisplayName("날짜 에러 확인")
    @Test
    void inputViewDateTest() {
        runException("32");
        Assertions.assertThat(output())
            .contains("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)",
                "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("중복 메뉴 에러 확인")
    @Test
    void inputViewDuplicateOrderTest() {
        runException("3", "해산물파스타-1,해산물파스타-1");
        Assertions.assertThat(output())
            .contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("없는 메뉴 에러 확인")
    @Test
    void inputViewNonExistOrderTest() {
        runException("3", "뼈해장국-1,해산물파스타-1");
        Assertions.assertThat(output())
            .contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 개수 미만 에러 확인")
    @Test
    void inputViewOrderLessCountTest() {
        runException("3", "바비큐립-0,해산물파스타-1");
        Assertions.assertThat(output())
            .contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 개수 초과 에러 확인")
    @Test
    void inputViewOrderOverCountTest() {
        runException("3", "바비큐립-10,해산물파스타-11");
        Assertions.assertThat(output())
            .contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("음료 주문 에러 확인")
    @Test
    void inputViewBeverageOrderTest() {
        runException("3", "제로콜라-1,레드와인-11");
        Assertions.assertThat(output())
            .contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("주문 형식 에러 확인")
    @Test
    void inputViewOrderFormTest() {
        runException("3", "제로콜라=1,레드와인-11-11");
        Assertions.assertThat(output())
            .contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Override
    protected void runMain() {
        InputView view = new InputView(new Menu(), new Validation());
        view.readDate();
        view.readOrder();
    }
}

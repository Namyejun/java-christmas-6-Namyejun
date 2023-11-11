package christmas.util;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Dish;
import christmas.domain.Menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    private Menu menu;
    private Validation validation;

    public InputView(Menu menu, Validation validation) {
        this.menu = menu;
        this.validation = validation;
    }

    public int readDate() throws IllegalArgumentException {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        while (true) {
            try {
                String input = Console.readLine();
                int date = validation.validateDate(input);

                return date;
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public List<Dish> readOrder() throws IllegalArgumentException {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        while (true) {
            try {
                String input = Console.readLine();
                List<Dish> returnList = validation.tokenizeOrder(input, menu);

                return returnList;
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
}
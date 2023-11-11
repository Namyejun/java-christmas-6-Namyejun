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

    public InputView(Menu menu) {
        this.menu = menu;
    }

    public int readDate() throws IllegalArgumentException {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        while (true) {
            try {
                String input = Console.readLine();

                int date = validateDate(input);
                return date;
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    private int validateDate(String input) {
        try {
            int date = Integer.parseInt(input);

            if (date < 1 || date > 31) {
                throw new NumberFormatException();
            }

            return date;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Dish> readOrder() throws IllegalArgumentException {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        while (true) {
            try {
                String input = Console.readLine();
                List<Dish> returnList = tokenizeOrder(input);
                return returnList;
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private List<Dish> tokenizeOrder(String input) {
        List<Dish> dishes = new ArrayList<>();
        String[] inputs = input.split(",");

        for (String eachInput : inputs) {
            String[] order = eachInput.split("-");
            String name = order[0];
            int count = validateCount(order[1]);
            dishes.add(new Dish(name, count));
        }

        validateOrder(dishes);

        return dishes;
    }

    private int validateCount(String input) {
        try {
            int count = Integer.parseInt(input);

            if (count < 1) {
                throw new NumberFormatException();
            }

            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private List<Dish> validateOrder(List<Dish> dishes) {
        Set<String> dishNames = new HashSet<>();

        for (Dish dish : dishes) {
            if (!menu.getDishs().containsKey(dish.getName()) && dishNames.contains(dish.getName())) {
                throw new IllegalArgumentException();
            }
            dishNames.add(dish.getName());
        }

        return dishes;
    }
}
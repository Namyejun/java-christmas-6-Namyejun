package christmas.util;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Dish;
import christmas.domain.DishSection;
import christmas.domain.Menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    int validateDate(String input) {
        try {
            int date = Integer.parseInt(input);

            if (date < 1 || date > 31) {
                throw new NumberFormatException();
            }

            return date;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    List<Dish> tokenizeOrder(String input, Menu menu) {
        List<Dish> dishes = new ArrayList<>();
        String[] inputs = input.split(",");

        for (String eachInput : inputs) {
            String[] order = validateForm(eachInput);
            String name = order[0];
            int count = validateCount(order[1]);
            dishes.add(new Dish(name, count));
        }

        validateOrder(dishes, menu);

        return dishes;
    }

    private String[] validateForm(String input) {
        String[] order = input.split("-");

        if (order.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        return order;
    }

    private int validateCount(String input) {
        try {
            int count = Integer.parseInt(input);

            if (count < 1) {
                throw new NumberFormatException();
            }

            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private List<Dish> validateOrder(List<Dish> dishes, Menu menu) {
        Set<String> dishNames = new HashSet<>();
        Set<DishSection> dishSections = new HashSet<>();
        int totalCount = 0;
        for (Dish dish : dishes) {
            eachDishValidate(dish, menu, dishNames);

            dishSections.add(menu.getDishs().get(dish.getName()).getSection());
            dishNames.add(dish.getName());
            totalCount += dish.getCount();
        }

        afterEachDishValidate(totalCount, dishSections);

        return dishes;
    }

    private void eachDishValidate(Dish dish, Menu menu, Set<String> dishNames) {
        if ((!menu.getDishs().containsKey(dish.getName())) || dishNames.contains(dish.getName())) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void afterEachDishValidate(int totalCount, Set<DishSection> dishSections) {
        if (totalCount > 20 || (dishSections.size() == 1 && dishSections.contains(DishSection.음료))) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }


}

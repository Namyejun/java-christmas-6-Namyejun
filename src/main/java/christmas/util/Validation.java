package christmas.util;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Dish;
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
            throw new IllegalArgumentException();
        }
    }

    List<Dish> tokenizeOrder(String input, Menu menu) {
        List<Dish> dishes = new ArrayList<>();
        String[] inputs = input.split(",");

        for (String eachInput : inputs) {
            String[] order = eachInput.split("-");
            String name = order[0];
            int count = validateCount(order[1]);
            dishes.add(new Dish(name, count));
        }

        validateOrder(dishes, menu);

        return dishes;
    }

    int validateCount(String input) {
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

    List<Dish> validateOrder(List<Dish> dishes, Menu menu) {
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

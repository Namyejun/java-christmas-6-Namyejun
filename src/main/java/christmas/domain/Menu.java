package christmas.domain;

import java.util.*;

public class Menu {
    private final List<String> menus = List.of(
        "양송이수프,에피타이저,6000", "타파스,에피타이저,5500", "시저샐러드,에피타이저,8000",
        "티본스테이크,메인,55000", "바비큐립,메인,54000", "해산물파스타,메인,35000", "크리스마스파스타,메인,25000",
        "초코케이크,디저트,15000", "아이스크림,디저트,5000",
        "제로콜라,음료,3000", "레드와인,음료,60000", "샴페인,음료,25000"
    );

    private Map<String, Dish> dishs = new HashMap<>();
    private int totalPrice;

    public Menu() {
        for (String menu : menus) {
            String[] eachMenu = menu.split(",");
            dishs.put(eachMenu[0], new Dish(eachMenu[0], DishSection.valueOf(eachMenu[1]), Integer.parseInt(eachMenu[2])));
        }
    }

    public Map<String, Dish> getDishs() {
        return dishs;
    }

    public void order(List<Dish> order) { // 여긴 모든 유효성 검사를 마친 주문이 들어온 것
        for (Dish dish : order) {
            dishs.get(dish.getName()).setCount(dish.getCount());
        }
    }

    public int getTotalPrice() {
        int returnVal = 0;

        for (Dish dish : dishs.values()) {
            returnVal += dish.getTotalPrice();
        }

        return returnVal;
    }
}

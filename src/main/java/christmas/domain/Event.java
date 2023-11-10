package christmas.domain;

import christmas.domain.Calendar;
import christmas.domain.Dish;
import christmas.domain.DishSection;
import christmas.domain.Menu;

import java.util.List;

public class Event{

    private int reserveDate = 0;
    private int mainCount = 0;
    private int dessertCount = 0;

    private Menu menu;
    private Calendar calendar = new Calendar();

    public Event(Menu menu, int reserveDate) {
        this.menu = menu;
        List<Dish> order = menu.getDishs().values().stream().toList();

        for (Dish dish : order) {
            if (dish.getSection().equals(DishSection.메인) && dish.getCount() != 0) {
                mainCount += dish.getCount();
            }

            if (dish.getSection().equals(DishSection.디저트) && dish.getCount() != 0) {
                dessertCount += dish.getCount();
            }
        }

        this.reserveDate = reserveDate;
    }

    public int calcTotalDiscount() {
        int discount = 0;

        if (menu.getTotalPrice() < 10000) {
            return discount;
        }

        discount += xmasDdayEvent();
        discount += starEvent();
        discount += dayEvent();
        discount += serviceEvent();

        return discount;
    }

    private int xmasDdayEvent() {
        int discountVal = 1000;

        for (int i = 1; i < reserveDate; i++) {
            discountVal += 100;
        }

        return discountVal;
    }

    private int starEvent() {
        if (!calendar.getStarDays().contains(reserveDate)) {
            return 0;
        }
        return 1000;
    }

    private int dayEvent() {
        if (calendar.getWeekday().contains(reserveDate)) {
            return dessertCount * 2023;
        }

        return mainCount * 2023;
    }

    private int serviceEvent() {
        if (menu.getTotalPrice() >= 120000) {
            menu.getDishs().get("샴페인").setCount(menu.getDishs().get("샴페인").getCount() + 1);
            return 25000;
        }

        return 0;
    }

}

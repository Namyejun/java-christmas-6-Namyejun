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

    private boolean eventValid() {
        if (menu.getTotalPrice() < 10000) {
            return true;
        }

        return false;
    }

    public String totalDiscountToString() {
        String returnVal = "<총혜택 금액>\n";
        returnVal += String.format("%,d원\n", (-1) * calcTotalDiscount());

        return returnVal;
    }

    public int calcTotalDiscount() {
        int discount = 0;

        if (eventValid()) {
            return discount;
        }

        discount += xmasDdayEvent();
        discount += starEvent();
        discount += weekdayEvent();
        discount += weekendEvent();
        discount += serviceEvent();

        return discount;
    }

    public String serviceToString() {
        String returnVal = "<증정 메뉴>\n";

        if (serviceEvent() == 25000) {
            return returnVal += "샴페인 1개\n";
        }

        return returnVal += "없음\n";
    }

    @Override
    public String toString() {
        String returnVal = "<혜택 내역>\n";

        if (eventValid()) {
            return returnVal + "없음\n";
        }

        returnVal += stringFormat("크리스마스 디데이 할인", xmasDdayEvent());
        returnVal += stringFormat("평일 할인", weekdayEvent());
        returnVal += stringFormat("주말 할인", weekendEvent());
        returnVal += stringFormat("특별 할인", starEvent());
        returnVal += stringFormat("증정 이벤트", serviceEvent());

        return returnVal;
    }

    private String stringFormat(String prefix, int x) {
        if (x < 0) {
            return "";
        }

        return prefix + ": " + String.format("%,d", x*(-1)) + "\n";
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

    private int weekdayEvent() {
        if (calendar.getWeekday().contains(reserveDate)) {
            return dessertCount * 2023;
        }

        return 0;
    }

    private int weekendEvent() {
        if (calendar.getWeekend().contains(reserveDate)) {
            return mainCount * 2023;
        }

        return 0;
    }

    private int serviceEvent() {
        if (menu.getTotalPrice() >= 120000) {
            return 25000;
        }

        return 0;
    }

}

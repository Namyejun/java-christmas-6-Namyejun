package christmas.util;

import christmas.domain.Customer;
import christmas.domain.Dish;
import christmas.domain.Event;
import christmas.domain.Menu;

public class OutputView {
    private Menu menu;
    private Event event;
    private Customer customer;

    public OutputView(Menu menu, Event event, Customer customer) {
        this.menu = menu;
        this.event = event;
        this.customer = customer;
    }

    public void start() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printMenu() {
        System.out.println(menu.toString());
    }

    public void beforeEvent() {
        System.out.println("<할인 전 총주문 금액>\n" + String.format("%,d원\n", menu.getTotalPrice()));
    }

    public void event() {
        System.out.println(event.serviceToString());
        System.out.println(event.toString());
        System.out.println(event.totalDiscountToString());
        System.out.println("<할인 후 예상 결제 금액>\n" + String.format("%,d원\n", menu.getTotalPrice() - event.calcTotalDiscount()));
    }

    public void badge() {
        System.out.println(customer.toString());
    }
}
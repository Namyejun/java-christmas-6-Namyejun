package christmas;

import christmas.domain.Customer;
import christmas.domain.Event;
import christmas.domain.Menu;
import christmas.util.InputView;
import christmas.util.OutputView;
import christmas.util.Validation;

public class Body {
    private Menu menu;
    private Customer customer;
    private Validation validation;
    private InputView inputView;

    private Event event;
    private OutputView outputView;

    private void beforeRunSetting() {
        menu = new Menu();
        customer = new Customer();
        validation = new Validation();
        inputView = new InputView(menu, validation);
    }

    private void afterRunSetting(int reserveDate) {
        event = new Event(menu, customer, reserveDate);
        outputView = new OutputView(menu, event, customer);
    }

    public void run() {
        beforeRunSetting();

        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        int reserveDate = inputView.readDate();

        afterRunSetting(reserveDate);

        menu.order(inputView.readOrder());

        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

        outputView.printMenu();
        outputView.beforeEvent();
        outputView.event();
        outputView.badge();
    }
}

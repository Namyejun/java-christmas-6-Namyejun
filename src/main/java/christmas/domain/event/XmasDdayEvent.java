package christmas.domain.event;

public class XmasDdayEvent implements Event{
    @Override
    public int discount(int reserveDate) {
        int discountVal = 1000;

        for (int i = 1; i < reserveDate; i++) {
            discountVal += 100;
        }

        return discountVal;
    }
}

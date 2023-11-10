package christmas.domain.event;

public class Event{
    public int xmasDdayEvent(int reserveDate) {
        int discountVal = 1000;

        for (int i = 1; i < reserveDate; i++) {
            discountVal += 100;
        }

        return discountVal;
    }
}

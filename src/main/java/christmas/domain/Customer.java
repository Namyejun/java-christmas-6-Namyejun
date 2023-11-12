package christmas.domain;

public class Customer {
    private Badge badgeOfDecember;

    public void setBadgeOfDecember(Badge badgeOfDecember) {
        this.badgeOfDecember = badgeOfDecember;
    }

    @Override
    public String toString() {
        return "<12월 이벤트 배지>" + System.lineSeparator() + badgeOfDecember.toString();
    }
}

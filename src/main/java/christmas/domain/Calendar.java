package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private final String firstDay = "FRIDAY";
    private final List<String> days = List.of("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY");

    public List<Integer> getWeekday() { // 금, 토를 제외한 일자를 출력
        List<Integer> weekday = new ArrayList<>();

        for (int i = 1; i <= 31; i++) {
            if ((i + days.indexOf(firstDay) - 1) % 7 < 5) {
                weekday.add(i);
            }
        }

        return weekday;
    }

    public List<Integer> getWeekend() { // 금, 토를 제외한 일자를 출력
        List<Integer> weekday = new ArrayList<>();

        for (int i = 1; i <= 31; i++) {
            if ((i + days.indexOf(firstDay) - 1) % 7 >= 5) {
                weekday.add(i);
            }
        }

        return weekday;
    }

    public List<Integer> getStarDays() {
        return List.of(3,10,17,24,25,31);
    }

    public int getXmas() {
        return 25;
    }
}

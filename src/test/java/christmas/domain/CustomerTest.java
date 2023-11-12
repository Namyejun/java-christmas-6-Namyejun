package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void customerTest() {
        Customer customer = new Customer();
        customer.setBadgeOfDecember(Badge.산타);

        Assertions.assertThat(customer.toString())
            .isEqualTo("<12월 이벤트 배지>\n산타");
    }

}

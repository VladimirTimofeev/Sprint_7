import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class PositiveOrderTest {

    private GetSteps getSteps = new GetSteps();

    @Test
    @DisplayName("Проверка получения списка заказов")
    public void checkGetRequesrOrders() {
        getSteps.getCheckRequestOrders();
    }
}
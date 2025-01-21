import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class PositiveOrderTest {

    private GetSteps getSteps = new GetSteps();

    //Проверка получения списка заказов
    @Test
    @DisplayName("Checking the receipt of the order list")
    public void checkGetRequesrOrders() {
        getSteps.getCheckRequestOrders();
    }
}
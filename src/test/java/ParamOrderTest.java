import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParamOrderTest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final Integer rentTime;
    private final String deliveryDate;
    private final String comment;
    private final String[] color;

    private PostSteps postSteps = new PostSteps();


    public ParamOrderTest(String firstName, String lastName, String address, String metroStation, String phone, Integer rentTime, String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] createOrder() {
        return new Object[][] {
                {"Иван", "Иванов", "Москва, ул. Тверская, д. 6", "10", "+79999999999", 5, "2025-04-04", "Привет", new String[]{"BLACK"}},
                {"Петр", "Петров", "Москва, ул. Лубянка, д. 10", "8", "+79999999988", 4, "2025-04-10", "Пока", new String[]{"GREY"}},
                {"Петр", "Иванов", "Москва, пр. Мира, д. 6", "11", "+79999999977", 3, "2025-04-25", "Привет, пока", new String[]{""}},
                {"Иван", "Петров", "Москва, пр. Мира, д. 6", "11", "+79999999977", 8, "2025-04-30", "К гаражу", new String[]{"BLACK", "GREY"}}
        };
    }

    @Test
    @DisplayName("Создание заказов с разными цветами самокатов")
    public void createNewOrders() {
        Order order = new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
        postSteps.createNewOrder(order);
    }
}

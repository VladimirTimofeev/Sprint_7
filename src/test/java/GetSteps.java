import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.notNullValue;
import static io.restassured.RestAssured.*;

public class GetSteps {

    private GetApi getApi = new GetApi();

    private Response response;

    //Запрос списка заказов
    @Step("Requesting a list of orders")
    private Response getRequestOrders() {
        return response = getApi.getRequestOrders();
    }

    //Проверка ответа списка заказов
    @Step("Checking the response of the order list")
    private void checkGetOrders(Response response) {
        response.then().assertThat()
                .statusCode(200)
                .body("orders.id", notNullValue());
    }

    public void getCheckRequestOrders() {
        response = getRequestOrders();
        checkGetOrders(response);
    }
}
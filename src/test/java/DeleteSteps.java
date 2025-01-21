import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;


public class DeleteSteps {


    private DeleteApi deleteApi = new DeleteApi();

    private Response response;

    private Response getDeleteCourier(Response response) {
        return deleteApi.deleteCourier(response);
    }

    //Проверка статуса 200 и тела запроса TRUE
    @Step("Checking the 200 status and body true")
    private void getCheckStatus200AndTrue(Response response) {
        response.then().assertThat()
                .statusCode(200)
                .body("ok", equalTo(true));
    }

    //Удаление курьера и запуск проверки тела ответа
    @Step("Deleting the courier and calling the request verification method")
    public void deleteCourierAndCheckRequest(Response response) {
        Response checkResponse = getDeleteCourier(response);
        getCheckStatus200AndTrue(checkResponse);
    }
}

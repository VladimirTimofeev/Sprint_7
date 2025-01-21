import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostSteps {

    private PostApi postApi = new PostApi();

    private Response response;

    //Создание курьера со всеми данными
    @Step("Creating a courier with all the data")
    private Response createCourier() {
        return response = postApi.postCreateCourier(CourierTestData.expectedCourier());
    }

    //Создание курьера в параметризованных тестах
    @Step("Creating a courier in parameterized tests")
    private Response createCourier(Courier courier) {
        return response = postApi.postCreateCourier(courier);
    }

    //Создание курьера без пароля
    @Step("Creating a courier without a password")
    private Response createCourierWithoutPassword() {
        return response = postApi.postCreateCourier(CourierTestData.courierWithoutPassword());
    }

    //Создание заказа
    @Step("Creating an order")
    private Response createOrder(Order order) {
        return response = postApi.postCreateOrder(order);
    }

    //Поиск клиента по логину
    @Step("Customer search by login")
    private Response findCourier() {
        return response = postApi.postFindCourier(CourierTestData.expectedCourier());
    }

    //Поиск курьера в параметризованных тестах
    @Step("Courier search in parameterized tests")
    private Response findCourier(Courier courier) {
        return response = postApi.postFindCourier(courier);
    }

     //Проверка статуса 201 и тела ответа OK
    @Step("Checking the 201 status and the OK response body")
    private void getCheckStatusCod201AndTrue(Response response) {
        response.then().assertThat()
                .statusCode(201)
                .body("ok", equalTo(true));
    }

    //Проверка статуса 201 и тела ответа TRACK
    @Step("Checking the 201 status and the TRACK response body")
    private void getCheckStatusCod201AndTrack(Response response) {
        response.then().assertThat()
                .statusCode(201)
                .body("track", notNullValue());
    }

    //Проверка статуса 200 и наличие ID
    @Step("Checking the 200 status and ID availability")
    private void getCheckStatusCod200(Response response) {
        response.then().assertThat()
                .statusCode(200)
                .body("id", notNullValue());
    }

    //Проверка статуса 400 и тела ответа
    @Step("Checking the 400 status and response body")
    private void getCheckStatusCod400(Response response) {
        response.then().assertThat()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    //Проверка статуса 404 и тела ответа
    @Step("Checking the 404 status and response body")
    private void getCheckStatusCod404(Response response) {
        response.then().assertThat()
                .statusCode(404)
                .body("message", equalTo("Учетная запись не найдена"));
    }

    //Проверка статуса 409 и тела ответа
    @Step("Checking the 409 status and response body")
    private void getCheckStatusCod409(Response response) {
        response.then().assertThat()
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    //Создание курьера с корректными данными
    @Step("Creating a courier with correct data")
    public void createAndCheckCorrectCourier() {
        response = createCourier();
        getCheckStatusCod201AndTrue(response);
    }

    //Создание курьера для параметризации
    @Step("Creating a courier for parameterization")
    public void createParametrezedCourier(Courier courier) {
        response = createCourier(courier);
        getCheckStatusCod201AndTrue(response);
    }

    //Поиск курьера
    @Step("Courier search")
    public Response findCourierAndCheckRequest() {
        response = findCourier();
        getCheckStatusCod200(response);
        return response;
    }

    //Поиск курьера  для параметризации
    @Step("Поиск курьера  для параметризации")
    public Response findCourierAndCheckRequest(Courier courier) {
        response = findCourier(courier);
        getCheckStatusCod200(response);
        return response;
    }

    //Создание второго одинакового курьера
    @Step("Creating a second identical courier")
    public void createDoubleCourier() {
        response = createCourier();
        getCheckStatusCod409(response);
    }

    //Создание курьера без пароля
    @Step("Creating a courier without a password")
    public void createCourierNotFullData() {
        response = createCourierWithoutPassword();
        getCheckStatusCod400(response);
    }

    //Поиск курьера с неверным паролем
    @Step("Search for a courier with an incorrect password")
    public void findCourierWithIncorrectPassword() {
        response = findCourier(CourierTestData.courierIncorrectPassword());
        getCheckStatusCod404(response);
    }

    //Создание нового заказа
    @Step("Creating a new order")
    public void createNewOrder(Order order) {
        response = createOrder(order);
        getCheckStatusCod201AndTrack(response);
    }
}
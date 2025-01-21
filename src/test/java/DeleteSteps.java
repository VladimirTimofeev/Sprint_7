import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;


public class DeleteSteps {


    private DeleteApi deleteApi = new DeleteApi();

    private Response response;

    private Response getDeleteCourier(Response response) {
        return deleteApi.deleteCourier(response);
    }

    private void getCheckStatus200AndTrue(Response response) {
        response.then().assertThat()
                .statusCode(200)
                .body("ok", equalTo(true));
    }

    public void deleteCourierAndCheckRequest(Response response) {
        Response checkResponse = getDeleteCourier(response);
        getCheckStatus200AndTrue(checkResponse);
    }
}

import io.restassured.response.Response;

public class DeleteApi extends BaseHttpClient{


    private final String apiPathDeleteCourier = "/api/v1/courier/";


    public Response deleteCourier(Response response) {
        String id = response.body().asString();
        id = id.substring(6, 12);
        return doDeleteReqiest(apiPathDeleteCourier + id);
    }
}

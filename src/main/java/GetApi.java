import io.restassured.response.Response;

public class GetApi extends BaseHttpClient{

    private final String apiPathRequestOrders = "/v1/orders?limit=10&page=0&nearestStation=[\"110\"]";

    public Response getRequestOrders() {
        return doGetRequest(apiPathRequestOrders);
    }
}

import io.restassured.response.Response;

public class PostApi extends BaseHttpClient{

    private final String apiPathCreateCourier = "/api/v1/courier/";
    private final String apiPathFindCourier = "/api/v1/courier/login";
    private final String apiPathCreateOrder = "/api/v1/orders";

    public Response postCreateCourier(Courier courier) {
        return doPostRequest(apiPathCreateCourier, courier);
    }

    public Response postFindCourier(Courier courier) {
        return doPostRequest(apiPathFindCourier, courier);
    }

    public Response postCreateOrder(Order order) {
        return doPostRequest(apiPathCreateOrder, order);
    }
}

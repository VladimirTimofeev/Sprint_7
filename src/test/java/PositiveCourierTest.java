import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import io.restassured.response.Response;

public class PositiveCourierTest {

    private PostSteps postSteps = new PostSteps();
    private DeleteSteps deleteSteps = new DeleteSteps();

    private Response response;

    //Создание курьера
    @Test
    @DisplayName("Creating a courier")
    public void createCourier() {
        postSteps.createAndCheckCorrectCourier();
    }

    @After
    public void deleteCourier() {
        response = postSteps.findCourierAndCheckRequest();
        deleteSteps.deleteCourierAndCheckRequest(response);
    }
}
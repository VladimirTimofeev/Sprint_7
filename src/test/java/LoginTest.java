import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {

    private PostSteps postSteps = new PostSteps();
    private DeleteSteps deleteSteps = new DeleteSteps();

    private Response response;

    @Before
    public void createCourier() {
        postSteps.createAndCheckCorrectCourier();
    }

    @Test
    @DisplayName("Courier authorization")
    public void authorizationCourier() {
        response = postSteps.findCourierAndCheckRequest();
    }

    @Test
    @DisplayName("Search for a courier with an incorrect password or attempt to authorize a courier with incorrect data")
    public void findCourierinkorrectPassword() {
        postSteps.findCourierWithIncorrectPassword();
    }

    @After
    public void deleteCourier() {
        response = postSteps.findCourierAndCheckRequest();
        deleteSteps.deleteCourierAndCheckRequest(response);
    }
}
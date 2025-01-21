import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParamCourierTest {

    private final String login;
    private final String password;
    private final String firstName;

    private PostSteps postSteps = new PostSteps();
    private DeleteSteps deleteSteps = new DeleteSteps();
    private Response response;

    public ParamCourierTest(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Parameterized.Parameters
    public static Object[][] checkErrorRequest() {
        return new Object[][] {
                {"asddsa123", "123321", "Иван"},
                {"asddsa123", "123123", "Петр"}
        };
    }

    @Test
    @DisplayName("Создание двух одинаковых курьеров и курьеров с одинаковым логином")
    public void createDoubleCourier() {
        Courier courier = new Courier(login, password, firstName);
        postSteps.createParametrezedCourier(courier);
        postSteps.createDoubleCourier();
    }

    @After
    public void deleteCourier() {
        Courier courier = new Courier(login, password, firstName);
        response = postSteps.findCourierAndCheckRequest(courier);
        deleteSteps.deleteCourierAndCheckRequest(response);
    }
}

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

public class NegativeTest {

    private PostSteps postSteps = new PostSteps();

    @Test
    @DisplayName("Verification of courier creation or authorization with incomplete data (without password)")
    public void checkCreateCourierIncompleteData() {
        postSteps.createCourierNotFullData();
    }
}
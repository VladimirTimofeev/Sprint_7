import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

public class NegativeTest {

    private PostSteps postSteps = new PostSteps();

    @Test
    @DisplayName("Проверка создания курьера или его авторизации с неполными данными (без пароля)")
    public void checkCreateCourierIncompleteData() {
        postSteps.createCourierNotFullData();
    }
}
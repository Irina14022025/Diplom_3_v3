import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.api.LoginModel;
import org.junit.Test;
import steps.api.UserSteps;


import static org.junit.Assert.assertEquals;
import static pages.HomePage.BASE_URL;
import static steps.api.UserSteps.deleteUser;
import static steps.api.UserSteps.userAuthorization;
import static test.data.TestValue.*;

public class RegistrationTest extends BaseTest {
    private LoginModel login;
    private UserSteps userSteps;
    private String accessToken;

    @Test
    @DisplayName("Проверили успешную регистрацию пользователя")
    public void registrationSuccessTest(){
        homePage.openPage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationLink();
        registrationPage.inputRegistrationForm(USER_NAME, USER_EMAIL, USER_PASSWORD);
        registrationPage.clickRegistrationButton();
        authorizationPage.waitForLoadAuthorizationForm();
        assertEquals("Регистрация не выполнена", "Вход", authorizationPage.findHeaderTextAuthorizationForm());
        RestAssured.baseURI = BASE_URL;
        userSteps = new UserSteps();
        login = new LoginModel(USER_EMAIL, USER_PASSWORD);
        Response response = userAuthorization(login);
        accessToken = response.path("accessToken");
        deleteUser(accessToken);
    }

    @Test
    @DisplayName("Проверили ошибку для некорректного пароля при регистрации пользователя")
    public void registrationIncorrectPasswordTest(){
        homePage.openPage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationLink();
        registrationPage.inputRegistrationForm(USER_NAME, USER_EMAIL, USER_INCORRECT_PASSWORD);
        registrationPage.clickRegistrationButton();
        assertEquals("Регистрация не выполнена", "Некорректный пароль", registrationPage.findIncorrectPasswordErrorText());
    }
}

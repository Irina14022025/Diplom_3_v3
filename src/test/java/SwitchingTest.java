import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.api.UserModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.api.UserSteps;

import static org.junit.Assert.assertEquals;
import static pages.HomePage.BASE_URL;
import static steps.api.UserSteps.createUser;
import static steps.api.UserSteps.deleteUser;
import static test.data.TestValue.*;

public class SwitchingTest extends BaseTest{
    private UserModel user;
    private UserSteps userSteps;
    private String accessToken;
    private String emailValue;
    private String passwordValue;

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        user = new UserModel(USER_EMAIL, USER_PASSWORD, USER_NAME);
        userSteps = new UserSteps();
        Response response = createUser(user);
        accessToken = response.path("accessToken");

    }


    @Test
    @DisplayName("Проверили переход в личный кабинет по кнопке Личный кабинет")
    public void transferToPersonalAccountTest(){
        emailValue = user.getEmail();
        passwordValue = user.getPassword();
        homePage.openPage();
        homePage.clickMainLoginAccountButton();
        authorizationPage.performingAuthorization(emailValue, passwordValue);
        homePage.waitForLoadHomePage();
        homePage.clickPersonalAccountButton();
        profilePage.waitForPersonalAccount();
        assertEquals("Переход в личный кабинет не выполнен", "Профиль", profilePage.findSectionProfileText());
        profilePage.clickExitProfileButton();
    }

    @Test
    @DisplayName("Проверили переход из личного кабинета в конструктор по клику на Конструктор")
    public void transferToConstructorByClickOnConstructor(){
        emailValue = user.getEmail();
        passwordValue = user.getPassword();
        homePage.openPage();
        homePage.clickMainLoginAccountButton();
        authorizationPage.performingAuthorization(emailValue, passwordValue);
        homePage.clickPersonalAccountButton();
        profilePage.waitForPersonalAccount();
        homePage.clickConstructorButton();
        homePage.waitForLoadHomePage();
        assertEquals("Переход в конструктор не выполнен", "Соберите бургер", homePage.findTextHeaderSectionBurgerIngredients());
        homePage.clickPersonalAccountButton();
        profilePage.clickExitProfileButton();
    }

    @Test
    @DisplayName("Проверили переход из личного кабинета в конструктор по клику на логотип Stellar burger")
    public void transferToConstructorByClickOnStellarBurger(){
        emailValue = user.getEmail();
        passwordValue = user.getPassword();
        homePage.openPage();
        homePage.clickMainLoginAccountButton();
        authorizationPage.performingAuthorization(emailValue, passwordValue);
        homePage.clickPersonalAccountButton();
        profilePage.waitForPersonalAccount();
        homePage.clickLogotypeStellarBurgers();
        homePage.waitForLoadHomePage();
        assertEquals("Переход в конструктор не выполнен", "Соберите бургер", homePage.findTextHeaderSectionBurgerIngredients());
        homePage.clickPersonalAccountButton();
        profilePage.clickExitProfileButton();
    }

    @Test
    @DisplayName("Проверили выход из личного кабинета по кнопке Выход")
    public void exitOfPersonalAccount(){
        emailValue = user.getEmail();
        passwordValue = user.getPassword();
        homePage.openPage();
        homePage.clickMainLoginAccountButton();
        authorizationPage.performingAuthorization(emailValue, passwordValue);
        homePage.clickPersonalAccountButton();
        profilePage.waitForPersonalAccount();
        profilePage.clickExitProfileButton();
        authorizationPage.waitForLoadAuthorizationForm();
        assertEquals("Выход из личного кабинета не выполнен", "Вход", authorizationPage.findHeaderTextAuthorizationForm());
    }


    @After
    public void cleanUp(){
        deleteUser(accessToken);
    }

}

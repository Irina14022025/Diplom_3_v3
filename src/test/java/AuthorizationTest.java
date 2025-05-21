
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
import static steps.api.UserSteps.*;
import static test.data.TestValue.*;


public class AuthorizationTest extends BaseTest {
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
    @DisplayName("Проверили авторизацию по кнопке «Войти в аккаунт» на домашней странице для тестового пользователя")
    public void authorizationMainLoginAccountTest(){
        emailValue = user.getEmail();
        passwordValue = user.getPassword();
        homePage.openPage();
        homePage.clickMainLoginAccountButton();
        authorizationPage.performingAuthorization(emailValue, passwordValue);
        homePage.waitForLoadHomePage();
        assertEquals("Авторизация не выполнена", "Оформить заказ", homePage.findTextMakeOrderButton());
        homePage.clickPersonalAccountButton();
        profilePage.clickExitProfileButton();
    }

    @Test
    @DisplayName("Проверили авторизацию по кнопке «Личный кабинет»")
    public void authorizationPersonalAccountTest(){
        emailValue = user.getEmail();
        passwordValue = user.getPassword();
        homePage.openPage();
        homePage.clickPersonalAccountButton();
        authorizationPage.performingAuthorization(emailValue, passwordValue);
        homePage.waitForLoadHomePage();
        assertEquals("Авторизация не выполнена", "Оформить заказ", homePage.findTextMakeOrderButton());
        homePage.clickPersonalAccountButton();
        profilePage.clickExitProfileButton();
    }

    @Test
    @DisplayName("Проверили авторизацию по ссылке «Войти» в форме регистрации")
    public void authorizationFromRegistrationFormTest(){
        emailValue = user.getEmail();
        passwordValue = user.getPassword();
        homePage.openPage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRegistrationLink();
        registrationPage.clickAuthorizationLinkFromRegistration();
        authorizationPage.performingAuthorization(emailValue, passwordValue);
        homePage.waitForLoadHomePage();
        assertEquals("Авторизация не выполнена", "Оформить заказ", homePage.findTextMakeOrderButton());
        homePage.clickPersonalAccountButton();
        profilePage.clickExitProfileButton();
    }

    @Test
    @DisplayName("Проверили авторизацию по ссылке «Войти» в форме восстановления пароля")
    public void authorizationFromRecoverPasswordFormTest(){
        emailValue = user.getEmail();
        passwordValue = user.getPassword();
        homePage.openPage();
        homePage.clickPersonalAccountButton();
        authorizationPage.clickRecoverPasswordLink();
        passwordRecoveryPage.clickAuthorizationLinkFromPasswordRecovery();
        authorizationPage.performingAuthorization(emailValue, passwordValue);
        homePage.waitForLoadHomePage();
        assertEquals("Авторизация не выполнена", "Оформить заказ", homePage.findTextMakeOrderButton());
        homePage.clickPersonalAccountButton();
        profilePage.clickExitProfileButton();
    }

    @After
    public void cleanUp(){
        deleteUser(accessToken);
    }
}

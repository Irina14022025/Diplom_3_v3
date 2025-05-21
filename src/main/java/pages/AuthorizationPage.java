package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage {
    private WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заголовок "Вход" для формы авторизации
    private By headerAuthorizationForm = By.xpath(".//div[@class = 'Auth_login__3hAey']/h2[text() = 'Вход']");

    // Кнопка "Войти"
    private By loginAuthorizationButton = By.xpath(".//button[text() = 'Войти']");

    // Ссылка на форму регистрации
    private By registrationLink = By.xpath(".//a[text() = 'Зарегистрироваться']");

    // Ссылка на форму восстановления пароля
    private By recoverPasswordLink = By.xpath(".//a[text() = 'Восстановить пароль']");

    // Поле "Email"
    private By authorizationEmailField = By.xpath("//label[text()='Email']/following-sibling::input");

    // Поле "Пароль"
    private By authorizationPasswordField = By.xpath(".//input[@type = 'password']");



    @Step("Подождали, пока загрузится форма авторизации")
    public void waitForLoadAuthorizationForm() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(headerAuthorizationForm));
    }

    @Step("Нажали на ссылку перехода на форму регистрации")
    public void clickRegistrationLink(){
        driver.findElement(registrationLink).click();
    }

    @Step("Нажали на ссылку перехода на форму восстановления пароля")
    public void clickRecoverPasswordLink(){
        driver.findElement(recoverPasswordLink).click();
    }

    @Step("Заполнили поле Email в форме авторизации")
    public void inputFieldEmailAuthorizationForm(String email) {
        driver.findElement(authorizationEmailField).clear();
        driver.findElement(authorizationEmailField).sendKeys(email);
    }

    @Step("Заполнили поле Пароль в форме авторизации")
    public void inputFieldPasswordAuthorizationForm(String password) {
        driver.findElement(authorizationPasswordField).clear();
        driver.findElement(authorizationPasswordField).sendKeys(password);
    }

    @Step("Нажали на кнопку Войти в форме авторизации")
    public void clickLoginAuthorizationButton(){
        driver.findElement(loginAuthorizationButton).click();
    }

    @Step("Получили текст заголовка Вход в форме авторизации")
    public String findHeaderTextAuthorizationForm(){
        return driver.findElement(headerAuthorizationForm).getText();
    }

    @Step("Выполнение авторизации")
    public void performingAuthorization(String email, String password){
        waitForLoadAuthorizationForm();
        inputFieldEmailAuthorizationForm(email);
        inputFieldPasswordAuthorizationForm(password);
        clickLoginAuthorizationButton();
    }
}

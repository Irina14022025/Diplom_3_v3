package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Зарегистрироваться"
    private By registrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");

    // Ссылка на форму авторизации
    private By authorizationLinkFromRegistration = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");

    // Поле "Имя"
    private By registrationNameField = By.xpath("//label[text()='Имя']/following-sibling::input");

    // Поле "Email"
    private By registrationEmailField = By.xpath("//label[text()='Email']/following-sibling::input");

    // Поле "Пароль"
    private By registrationPasswordField = By.xpath(".//input[@type = 'password']");

    // Текст ошибки некорректного пароля
    private By incorrectPasswordErrorText = By.xpath(".//p[text() = 'Некорректный пароль']");



    @Step("Заполнили поле Имя в форме регистрации")
    public void inputFieldNameRegistrationForm(String name) {
        driver.findElement(registrationNameField).clear();
        driver.findElement(registrationNameField).sendKeys(name);
    }

    @Step("Заполнили поле Email в форме регистрации")
    public void inputFieldEmailRegistrationForm(String email) {
        driver.findElement(registrationEmailField).clear();
        driver.findElement(registrationEmailField).sendKeys(email);
    }

    @Step("Заполнили поле Пароль в форме регистрации")
    public void inputFieldPasswordRegistrationForm(String password) {
        driver.findElement(registrationPasswordField).clear();
        driver.findElement(registrationPasswordField).sendKeys(password);
    }

    @Step("Нажали на кнопку Зарегистрироваться")
    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }

    @Step("Получили текст ошибки некорректного пароля")
    public String findIncorrectPasswordErrorText(){
        return driver.findElement(incorrectPasswordErrorText).getText();
    }

    @Step("Нажали на ссылку Войти в форме регистрации")
    public void clickAuthorizationLinkFromRegistration(){
        driver.findElement(authorizationLinkFromRegistration).click();
    }

    @Step("Заполнили форму регистрации")
    public void inputRegistrationForm(String name, String email, String password){
        inputFieldNameRegistrationForm(name);
        inputFieldEmailRegistrationForm(email);
        inputFieldPasswordRegistrationForm(password);
    }
}

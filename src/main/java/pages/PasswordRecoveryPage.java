package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    // Ссылка на форму авторизации
    private By authorizationLinkFromPasswordRecovery = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");

    @Step("Нажали на ссылку Войти в форме восстановления пароля")
    public void clickAuthorizationLinkFromPasswordRecovery(){
        driver.findElement(authorizationLinkFromPasswordRecovery).click();
    }
}

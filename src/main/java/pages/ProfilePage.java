package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }


    // Кнопка "Выход" в личном кабинете
    private By exitProfileButton = By.xpath(".//button[text() = 'Выход']");

    // Раздел "Профиль" в личном кабинете
    private By sectionProfileText = By.xpath(".//a[text() = 'Профиль']");

    @Step("Нажали на кнопку Выход в личном кабинете")
    public void clickExitProfileButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(exitProfileButton));
        driver.findElement(exitProfileButton).click();
    }

    @Step("Подождали, пока загрузится Личный кабинет")
    public void waitForPersonalAccount(){
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.visibilityOfElementLocated(sectionProfileText));
    }

    @Step("Получили текст Профиль в личном кабинете")
    public String findSectionProfileText(){
        return driver.findElement(sectionProfileText).getText();
    }
}

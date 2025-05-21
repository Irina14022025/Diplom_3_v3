package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Логотип "Stellar burgers"
    private By logotypeStellarBurgers = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']");

    // Заголовок "Соберите бургер" для секции ингредиентов бургера на главной странице
    private By headerSectionBurgerIngredients = By.xpath(".//h1[text() = 'Соберите бургер']");

    // Кнопка "Войти в аккаунт"
    private By mainLoginAccountButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    // Кнопка "Личный кабинет"
    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    // Кнопка "Конструктор"
    private By constructorButton = By.xpath(".//p[text() = 'Конструктор']");

    // Кнопка "Оформить заказ"
    private By makeOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    // Кнопка раздела Булки
    private By sectionBreadButton = By.xpath("//span[text() = 'Булки']/..");

    // Открытый раздел Булки
    private By openSectionBread = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Булки']");

    // Кнопка раздела Соусы
    private By sectionSauceButton = By.xpath("//span[text()='Соусы']/..");

    // Открытый раздел Соусы
    private By openSectionSauce = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Соусы']");

    // Кнопка раздела Начинки
    private By sectionFillingButton = By.xpath("//span[text() = 'Начинки']/..");

    // Открытый раздел Начинки
    private By openSectionFilling = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Начинки']");


    @Step("Открыли домашнюю страницу браузера")
    public void openPage(){
        driver.get(BASE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.visibilityOfElementLocated(headerSectionBurgerIngredients));
    }


    @Step("Подождали, пока загрузится домашняя страница")
    public void waitForLoadHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.visibilityOfElementLocated(headerSectionBurgerIngredients));
    }

    @Step("Нажали на логотип Stellar burgers")
    public void clickLogotypeStellarBurgers(){
        driver.findElement(logotypeStellarBurgers).click();
    }

    @Step("Нажали на кнопку Войти в аккаунт")
    public void clickMainLoginAccountButton(){
        driver.findElement(mainLoginAccountButton).click();
    }

    @Step("Нажали на кнопку Личный Кабинет")
    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажали на кнопку Конструктор")
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }

    @Step("Получили текст кнопки Оформить заказ")
    public String findTextMakeOrderButton(){
        return driver.findElement(makeOrderButton).getText();
    }

    @Step("Получили текст заголовка секции Соберите бургер")
    public String findTextHeaderSectionBurgerIngredients(){
        return driver.findElement(headerSectionBurgerIngredients).getText();
    }

    @Step("Проверили, что раздел Соусы открылся по клику")
    public boolean checkOpenSectionSauce(){
        driver.findElement(sectionSauceButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.visibilityOfElementLocated(openSectionSauce));
        return driver.findElement(openSectionSauce).isDisplayed();
    }

    @Step("Проверили, что раздел Булки открылся по клику")
    public boolean checkOpenSectionBread(){
        driver.findElement(sectionSauceButton).click();
        driver.findElement(sectionBreadButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.visibilityOfElementLocated(openSectionBread));
        return driver.findElement(openSectionBread).isDisplayed();
    }

    @Step("Проверили, что раздел Начинки открылся по клику")
    public boolean checkOpenSectionFilling(){
        driver.findElement(sectionFillingButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.visibilityOfElementLocated(openSectionFilling));
        return driver.findElement(openSectionFilling).isDisplayed();
    }
}

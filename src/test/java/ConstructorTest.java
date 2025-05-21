import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Проверили переход в раздел Булки")
    public void transferToSectionBread(){
        homePage.openPage();
        assertTrue("Переход в раздел Булки не выполнен", homePage.checkOpenSectionBread());
    }

    @Test
    @DisplayName("Проверили переход в раздел Соусы")
    public void transferToSectionSauce(){
        homePage.openPage();
        assertTrue("Переход в раздел Соусы не выполнен", homePage.checkOpenSectionSauce());
    }

    @Test
    @DisplayName("Проверили переход в раздел Начинки")
    public void transferToSectionFilling(){
        homePage.openPage();
        assertTrue("Переход в раздел Соусы не выполнен", homePage.checkOpenSectionFilling());
    }
}

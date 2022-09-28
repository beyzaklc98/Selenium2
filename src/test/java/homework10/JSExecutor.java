package homework10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class JSExecutor extends TestBaseBeforeAfter {

    // Yeni bir class olusturun : ScroolInto
    // hotelmycamp anasayfasina gidin
    // 2 farkli test method’u olusturarak actions classi ve
    // Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
    // istediginiz oda inceleme sayfasi acildigini test  edin

    @Test
    public void test() throws InterruptedException {

        // hotelmycamp anasayfasina gidin
        driver.get("https://hotelmycamp.com");

        // 2 farkli test method’u olusturarak actions classi ve
        // Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
        // actions ile->
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]")).click();
        // jse ile->
        JavascriptExecutor jsE = (JavascriptExecutor) driver;
        WebElement room = driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]"));
        jsE.executeScript("arguments[0].scrollIntoView(true);", room);
        jsE.executeScript("arguments[0].click()", room);

        // istediginiz oda inceleme sayfasi acildigini test  edin
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='dsafsaf']")).isDisplayed());
    }
}

package homework7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class homework3 {

    /*
    1."http://webdriveruniversity.com/" adresine gidin
    2."Login Portal" a  kadar asagi inin
    3."Login Portal" a tiklayin  4.Diger window'a gecin
    5."username" ve  "password" kutularina deger yazdirin
    6."login" butonuna basin
    7.Popup'ta cikan yazinin "validation failed" oldugunu test edin  8.Ok diyerek Popup'i kapatin
    Ilk sayfaya geri donun
    Ilk sayfaya donuldugunu test edin
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test(){
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkAdres=driver.getWindowHandle();
        // 2."Login Portal" a  kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        // 3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
        // 4.Diger window'a gecin *
        List<String> windowHandle = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandle.get(1));
        // 5."username" ve  "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("bayza");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456789");
        // username.sendKeys("username");
        // actions.sendKeys(Keys.TAB).sendKeys("12345").perform();

        // 6."login" butonuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin *
        String actual = driver.switchTo().alert().getText();
        String expected = "validation failed";
        Assert.assertEquals(actual, expected);
        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        // Ilk sayfaya geri donun
        driver.switchTo().window(ilkAdres);
        // Ilk sayfaya donuldugunu test edin *
        String actualTitle = driver.getTitle();
        String expectedTitle = "WebDriverUniversity.com";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}

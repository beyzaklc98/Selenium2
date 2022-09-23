package practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Pratik4 {

    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
    }
    @After
    public void tesrDown(){
        driver.close();
    }
    @Test
    public void test1(){
        // titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void test2(){
        // imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement resim= driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(resim.isDisplayed());
    }
    @Test
    public void test3(){
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='search_query']"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void test4(){
        // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unExpectedTitle = "youTube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(unExpectedTitle, actualTitle);
    }

}

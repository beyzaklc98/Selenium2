package homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework1_YanlisMailTesti {

       /*
       1. Bir Class olusturalim YanlisEmailTesti
       2. http://automationpractice.com/index.php sayfasina gidelim
       3. Sign in butonuna basalim
       4. Email kutusuna @isareti olmayan bir mail yazip enter’a
          bastigimizda “Invalid email address” uyarisi ciktigini test edelim.
       */

    WebDriver driver;
    @Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
        // 3. Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();
    }

    @Test
    public void test2(){
        // 4. Email kutusuna @isareti olmayan bir mail yazip enter’a
        //    bastigimizda “Invalid email address” uyarisi ciktigini test edelim.
        driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("beyza_gmail.com"+ Keys.ENTER);
        WebElement uyari= driver.findElement(By.xpath("//*[text()=' Newsletter : Invalid email address.']"));
        Assert.assertTrue(uyari.isDisplayed());

    }
}

package pratic1;

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

public class Pratik2 {

/*
    - Amazon sayfasına gidelim
    3 farklı test methodu oluşturalım
      a-Url'nin amazon içerdiğini test edelim
      b-Title'in facebook içermediğini test edelim
      c- sol üst köşede amazon logosunun göründüğünü test edelim
      d- Url'nin www.facebook.com olduğunu test edin
     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1(){
        //  a-Url'nin amazon içerdiğini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
    @Test
    public void test2(){
        //  b-Title'in facebook içermediğini test edelim
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        // c- sol üst köşede amazon logosunun göründüğünü test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4(){
        // d- Url'nin www.facebook.com olduğunu test edin
        String expectedUrl= "http://www.facebook.com";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl, actualUrl);
    }


}

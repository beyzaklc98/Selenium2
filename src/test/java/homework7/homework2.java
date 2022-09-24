package homework7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class homework2 {

    /*
    “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    “Our Products” butonuna basin
    “Cameras product”i tiklayin
    Popup mesajini yazdirin
    “close” butonuna basin
    "WebdriverUniversity.com (IFrame)" linkini tiklayin
    "http://webdriveruniversity.com/index.html" adresine gittigini test edin
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        // “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        // “Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
        // “Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[@id='camera-img']")).click();
        // Popup mesajini yazdirin *
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")));
        String mesaj= driver.findElement(By.className("modal-body")).getText();
        System.out.println(mesaj);
        // “close” butonuna basin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        driver.switchTo().defaultContent();
        // "WebdriverUniversity.com (IFrame)" linkini tiklayin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();
        // "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}

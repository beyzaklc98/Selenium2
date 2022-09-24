package homework7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class homework1 {

    /*
    "http://webdriveruniversity.com/Actions" sayfasina gidin
    "Hover over Me First" kutusunun ustune gelin
    "Link 1" e tiklayin
    Popup mesajini yazdirin
    Popup'i tamam diyerek kapatin
    "Click and hold" kutusuna basili tutun
    "Click and hold" kutusunda cikan yaziyi yazdirin
    "Double click me" butonunu cift tiklayin
     */

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        //driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        // "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        WebElement hoverOverMeFirstLink = driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        actions.moveToElement(hoverOverMeFirst).perform();
        Thread.sleep(1500);
        actions.moveToElement(hoverOverMeFirstLink).click().perform();
        Thread.sleep(1500);
        // Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        // Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(1500);
        // "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButton = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAndHoldButton).perform();
        Thread.sleep(2000);
        // "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldButton.getText());
        // "Double click me" butonunu cift tiklayin
        Thread.sleep(2000);
        WebElement doubleClick = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(doubleClick).perform();
    }
}

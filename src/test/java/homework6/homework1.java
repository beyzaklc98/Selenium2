package homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class homework1 {

    /*
    Yeni Class olusturun ActionsClassHomeWork
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    2- Hover over Me First" kutusunun ustune gelin
    3- Link 1" e tiklayin
    4- Popup mesajini yazdirin
    5- Popup'i tamam diyerek kapatin
    6- "Click and hold" kutusuna basili tutun
    7-"Click and hold" kutusunda cikan yaziyi yazdirin
    8- "Double click me" butonunu cift tiklayin
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
        //  1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //  2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("(//button)[2]"));
        actions.moveToElement(hoverOverMeFirst).perform();
        Thread.sleep(2000);
        //Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();
        Thread.sleep(2000);
        //  4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //  5- Popup'i tamam diyerek kapatin
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        //  6- "Click and hold" kutusuna basili tutun
        WebElement hold = driver.findElement(By.xpath("//*[@id='click-box']"));
        Thread.sleep(2000);
        actions.clickAndHold(hold).perform();
        //  7-"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(hold.getText());
        //  8- "Double click me" butonunu cift tiklayin
        Thread.sleep(2000);
        WebElement doubleClick= driver.findElement(By.xpath("//h2"));
        actions.doubleClick(doubleClick).perform();
    }
    }

